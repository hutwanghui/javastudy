package com.kk.javabasic.Redis.queue;

import java.io.IOException;

/**
 * Created by hutwanghui on 2018/8/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class RedisQueue {
    public static byte[] redisKey = "key".getBytes();

    static {
       /* try {
           //init();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    private static void init() throws IOException {
        for (int i = 0; i < 1000; i++) {
            Message message = new Message(i, "这是第" + i + "个内容");
            JedisUtil.lpush(redisKey, ObjectUtil.object2Bytes(message));
        }

    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 1000; i++) {
                Message message = new Message(i, "这是第" + i + "个内容");
                JedisUtil.lpush(redisKey, ObjectUtil.object2Bytes(message));
                pop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pop() throws Exception {
        byte[] bytes = JedisUtil.rpop(redisKey);
        Message msg = (Message) ObjectUtil.bytes2Object(bytes);
        if (msg != null) {
            System.out.println(msg.getId() + "----" + msg.getContent());
        }
    }
}
