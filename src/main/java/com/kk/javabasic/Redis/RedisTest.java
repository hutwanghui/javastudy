package com.kk.javabasic.Redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hutwanghui on 2018/8/6.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis redis = new Jedis("193.112.163.175", 6379, 400000);
        redis.auth("hadoop@spark");
        Map<String, String> map = new HashMap<>();
        redis.select(8);
//        redis.flushDB();
        long start = System.currentTimeMillis();
        //直接hmset
        for (int i = 0; i < 1000; i++) {
            map.clear();
            map.put("k_" + i, "v_" + i);
            redis.hmset("key_" + i, map);
        }
        long end = System.currentTimeMillis();
        System.out.println("dbsize:[" + redis.dbSize() + "] .. ");
        System.out.println("hmset insert basic used [" + (end - start) / 1000 + "] seconds ..");

        //使用pipeline hmset
        // 先创建一个pipeline的链接对象
        Pipeline pipeline = redis.pipelined();
        start = System.currentTimeMillis();
        //redis.flushAll();
        for (int i = 0; i < 1000; i++) {
            map.clear();
            pipeline.set("pipk_" + i, map.put("pipk_" + i, "pipv_" + i));
        }
        // 获取所有的response
        pipeline.sync();
        end = System.currentTimeMillis();
        System.out.println("dbsize:[" + redis.dbSize() + "] .. ");
        System.out.println("hmset with pipeline used [" + (end - start) + "] seconds ..");

        //hmget
        Set<String> keys = redis.keys("*");
        //直接使用Jedis hgetall
        start = System.currentTimeMillis();
        Map<String, Map<String, String>> result = new HashMap<>();
        for (String key : keys) {
            result.put(key, redis.hgetAll(key));
        }
        end = System.currentTimeMillis();
        System.out.println("result size:[" + result.size() + "] ..");
        System.out.println("hgetAll without pipeline used [" + (end - start) / 1000 + "] seconds ..");
        //使用pipeline hgetall
        Map<String, Response<Map<String, String>>> responses = new HashMap<>(keys.size());
        result.clear();
        start = System.currentTimeMillis();
        for (String key : keys) {
            responses.put(key, pipeline.hgetAll(key));
        }
        pipeline.sync();
        for (String k : responses.keySet()) {
            result.put(k, responses.get(k).get());
        }
        end = System.currentTimeMillis();
        System.out.println("result size:[" + result.size() + "] ..");
        System.out.println("hgetAll with pipeline used [" + (end - start) / 1000 + "] seconds ..");
        redis.disconnect();
    }
}
