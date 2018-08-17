package com.kk.javabasic.Thread.sync;

/**
 * Created by msi- on 2018/6/23.
 */

import java.util.LinkedList;

/**
 * wait()方法：当缓冲区已满/空时，
 * 生产者/消费者线程停止自己的执行，放弃锁，使自己处于等等状态，让其他线程执行。
 * notify()方法：当生产者/消费者向缓冲区放入/取出一个产品时，
 * 向其他等待的线程发出可执行的通知，同时放弃锁，使自己处于等待状态。
 */
public class WaitAndNotify {
    //设置消息队列的最大容量
    private final int MAX_SIZE = 10;

    //队列载体
    private LinkedList<Object> queue = new LinkedList<Object>();

    public void produce(String producer) {
        synchronized (queue) {
            while (queue.size() == MAX_SIZE) {
                //区满，停止生产
                try {
                    System.out.println("仓库已满，【" + producer + "】： 暂时不能执行消费任务!");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(new Object());
            System.out.println("【" + producer + "】：生产了一个产品\t【现仓储量为】:" + queue.size());
            queue.notifyAll();
        }
    }

    public void consume(String consumer) {
        synchronized (queue) {
            while (queue.size() == 0) {
                //队列为空停止消费
                try {
                    System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.remove();
            System.out.println("【" + consumer + "】：消费了一个产品\t【现仓储量为】:" + queue.size());
            queue.notifyAll();
        }
    }

    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        for (int i = 1; i < 6; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    waitAndNotify.produce(String.format("生成者%d:", finalI));
                }
            }).start();
            if (i % 2 == 0) {
                int j = 3;
                while (j > 0) {
                    new Thread(() -> waitAndNotify.consume(String.format("消费者%d:", finalI))).start();
                    j--;
                }
            }
        }
    }

}
