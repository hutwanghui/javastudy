package com.kk.javabasic.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hutwanghui on 2018/8/7.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/*
集合：用户包裹：inventory
散列：用户信息: users
有序集合：市场：market(物品名称.买家id,价格)
 */
public class SampleTransaction {
    public static final void main(String[] args) {
        new SampleTransaction().run();
    }

    public void run() {
        Jedis conn = new Jedis("193.112.163.175", 6379, 400000);
        conn.auth("hadoop@spark");
        conn.select(15);
        testListItem(conn, false);
        testPurchaseItem(conn);
        testBenchmarkUpdateToken(conn);
    }

    public void testListItem(Jedis conn, boolean nested) {
        if (!nested) {
            System.out.println("\n----- testListItem -----");
        }

        System.out.println("We need to set up just enough state so that a user can list an item");
        String seller = "userX";
        String item = "itemX";
        //集合添加(添加购物车)
        conn.sadd("inventory:" + seller, item);
        //集合获取
        Set<String> i = conn.smembers("inventory:" + seller);

        System.out.println("The user's inventory has:");
        //集合遍历
        for (String member : i) {
            System.out.println("  " + member);
        }
        assert i.size() > 0;
        System.out.println();

        System.out.println("Listing the item...");
        boolean l = listItem(conn, item, seller, 10);
        System.out.println("Listing the item succeeded? " + l);
        assert l;

        Set<Tuple> r = conn.zrangeWithScores("market:", 0, -1);
        System.out.println("The market contains:");
        //有序集合遍历
        for (Tuple tuple : r) {
            System.out.println("  " + tuple.getElement() + ", " + tuple.getScore());
        }
        assert r.size() > 0;
    }

    public void testPurchaseItem(Jedis conn) {
        System.out.println("\n----- testPurchaseItem -----");
        testListItem(conn, true);

        System.out.println("We need to set up just enough state so a user can buy an item");
        conn.hset("users:userY", "funds", "125");
        Map<String, String> r = conn.hgetAll("users:userY");
        System.out.println("The user has some money:");
        for (Map.Entry<String, String> entry : r.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        assert r.size() > 0;
        assert r.get("funds") != null;
        System.out.println();

        System.out.println("Let's purchase an item");
        boolean p = purchaseItem(conn, "userY", "itemX", "userX", 10);
        System.out.println("Purchasing an item succeeded? " + p);
        assert p;
        r = conn.hgetAll("users:userY");
        System.out.println("Their money is now:");
        for (Map.Entry<String, String> entry : r.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        assert r.size() > 0;

        String buyer = "userY";
        Set<String> i = conn.smembers("inventory:" + buyer);
        System.out.println("Their inventory is now:");
        for (String member : i) {
            System.out.println("  " + member);
        }
        assert i.size() > 0;
        assert i.contains("itemX");
        assert conn.zscore("market:", "itemX.userX") == null;
    }

    public void testBenchmarkUpdateToken(Jedis conn) {
        System.out.println("\n----- testBenchmarkUpdate -----");
        benchmarkUpdateToken(conn, 5);
    }

    public boolean listItem(
            Jedis conn, String itemId, String sellerId, double price) {

        String inventory = "inventory:" + sellerId;
        String item = itemId + '.' + sellerId;
        long end = System.currentTimeMillis() + 5000;

        while (System.currentTimeMillis() < end) {
            conn.watch(inventory);
            if (!conn.sismember(inventory, itemId)) {
                conn.unwatch();
                return false;
            }

            //事务开启(即销售的时候是一个事务)
            Transaction trans = conn.multi();
            //有序集合提交
            trans.zadd("market:", price, item);
            //集合删除
            trans.srem(inventory, itemId);
            //事务提交
            List<Object> results = trans.exec();
            // null response indicates that the transaction was aborted due to
            // the watched key changing.
            if (results == null) {
                continue;
            }
            return true;
        }
        return false;
    }

    //买东西
    public boolean purchaseItem(
            Jedis conn, String buyerId, String itemId, String sellerId, double lprice) {

        String buyer = "users:" + buyerId;
        String seller = "users:" + sellerId;
        String item = itemId + '.' + sellerId;
        String inventory = "inventory:" + buyerId;
        long end = System.currentTimeMillis() + 10000;

        while (System.currentTimeMillis() < end) {
            conn.watch("market:", buyer);

            double price = conn.zscore("market:", item);
            double funds = Double.parseDouble(conn.hget(buyer, "funds"));
            if (price != lprice || price > funds) {
                conn.unwatch();
                return false;
            }

            //购买的时候是一个事务
            Transaction trans = conn.multi();
            trans.hincrBy(seller, "funds", (int) price);
            trans.hincrBy(buyer, "funds", (int) -price);
            trans.sadd(inventory, itemId);
            trans.zrem("market:", item);
            List<Object> results = trans.exec();
            // null response indicates that the transaction was aborted due to
            // the watched key changing.
            if (results == null) {
                continue;
            }
            return true;
        }

        return false;
    }

    /**
     * 同样的时间发送的次数
     * updateToken 7 5 1
     updateTokenPipeline 24972 5 4994
     * @param conn
     * @param duration
     */
    public void benchmarkUpdateToken(Jedis conn, int duration) {
        try {
            @SuppressWarnings("rawtypes")
            Class[] args = new Class[]{
                    Jedis.class, String.class, String.class, String.class};
            Method[] methods = new Method[]{
                    this.getClass().getDeclaredMethod("updateToken", args),
                    this.getClass().getDeclaredMethod("updateTokenPipeline", args),
            };
            for (Method method : methods) {
                int count = 0;
                long start = System.currentTimeMillis();
                long end = start + (duration * 1000);
                while (System.currentTimeMillis() < end) {
                    count++;
                    method.invoke(this, conn, "token", "user", "item");
                }
                long delta = System.currentTimeMillis() - start;
                System.out.println(
                        method.getName() + ' ' +
                                count + ' ' +
                                (delta / 1000) + ' ' +
                                (count / (delta / 1000)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateToken(Jedis conn, String token, String user, String item) {
        long timestamp = System.currentTimeMillis() / 1000;
        conn.hset("login:", token, user);
        conn.zadd("recent:", timestamp, token);
        if (item != null) {
            conn.zadd("viewed:" + token, timestamp, item);
            conn.zremrangeByRank("viewed:" + token, 0, -26);
            conn.zincrby("viewed:", -1, item);
        }
    }

    /**
     * 非事务型流水线
     * @param conn
     * @param token
     * @param user
     * @param item
     */
    public void updateTokenPipeline(Jedis conn, String token, String user, String item) {
        long timestamp = System.currentTimeMillis() / 1000;

        Pipeline pipe = conn.pipelined();
        pipe.multi();
        pipe.hset("login:", token, user);
        pipe.zadd("recent:", timestamp, token);
        if (item != null) {
            pipe.zadd("viewed:" + token, timestamp, item);
            pipe.zremrangeByRank("viewed:" + token, 0, -26);
            pipe.zincrby("viewed:", -1, item);
        }
        pipe.exec();
    }
}
