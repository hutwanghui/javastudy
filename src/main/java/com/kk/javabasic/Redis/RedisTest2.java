package com.kk.javabasic.Redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by hutwanghui on 2018/8/6.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class RedisTest2 {
    private static Logger logger = LoggerFactory.getLogger(RedisTest2.class);

    public static void main(String[] args) throws InterruptedException {
        Jedis redis = new Jedis("193.112.163.175", 6379, 400000);
        redis.auth("hadoop@spark");
        redis.select(8);
        long start = System.currentTimeMillis();
/*        for (int i = 0; i < 2000; i++) {
            redis.set(String.valueOf(i), String.valueOf(i));
        }*/
        long end = System.currentTimeMillis();
        logger.info("the jedis total time is:" + (end - start));

        Pipeline pipe = redis.pipelined();// 先创建一个pipeline的链接对象
        long start_pipe = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            pipe.set(String.valueOf(i), String.valueOf(i));
        }
        pipe.sync();// 获取所有的response
        long end_pipe = System.currentTimeMillis();
        logger.info("the pipe total time is:" + (end_pipe - start_pipe));

        BlockingQueue<String> logQueue = new LinkedBlockingQueue<String>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            logQueue.put("i=" + i);
        }
        long stop = System.currentTimeMillis();
        logger.info("the BlockingQueue total time is:" + (stop - begin));
    }
}
