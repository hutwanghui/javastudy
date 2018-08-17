package com.kk.javabasic.Redis;

import redis.clients.jedis.Jedis;

/**
 * Created by hutwanghui on 2018/8/7.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class PubAndSub {
    public void pubisher() {

    }

    public static void main(String[] args) {
        Jedis redis = new Jedis("193.112.163.175", 6379, 400000);
        redis.auth("hadoop@spark");
        redis.select(8);

    }
}
