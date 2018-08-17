package com.kk.javabasic.Thread.concurrent;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞的同步队列
 * put()方法：类似于我们上面的生产者线程，容量达到最大时，自动阻塞。
 * <p>
 * take()方法：类似于我们上面的消费者线程，容量为0时，自动阻塞。
 */
public class BlockingQueue_demo {

    private final int MAX_SIZE = 5;
    private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(MAX_SIZE);

    public void produce(String producer) {
        if (queue.size() == MAX_SIZE) {
            System.out.println("生成队列满，生产者" + producer + "无法进行生产");
            return;
        }
        try {
            queue.put(new Object());
            System.out.println("【生产者" + producer + "】生成了一个产品，现在仓库存数为：" + queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void consume(String consumer) {
        if (queue.size() == 0) {
            System.out.println("生产队列空，消费者" + consumer + "无法进行消费");
            return;
        }
        try {
            queue.take();
            System.out.println("【消费者" + consumer + "】消费了一个产品，现在仓库存数为:" + queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue_demo bk = new BlockingQueue_demo();
        for (int i = 1; i < 6; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    bk.produce(String.format("生成者%d:", finalI));
                }
            }).start();
            if (i % 2 == 0) {
                int j = 3;
                while (j > 0) {
                    new Thread(() -> bk.consume(String.format("消费者%d:", finalI))).start();
                    j--;
                }
            }
        }
    }
}
