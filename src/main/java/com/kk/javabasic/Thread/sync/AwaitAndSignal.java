package com.kk.javabasic.Thread.sync;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同理的生产者消费者模式，使用Lock的Api实现
 */
public class AwaitAndSignal {

    private final int MAX_VALUE = 10;

    private LinkedList<Object> linkedList = new LinkedList<>();

    //锁
    private final Lock lock = new ReentrantLock();

    //空队列条件
    private final Condition empty = lock.newCondition();

    //满队列条件
    private final Condition full = lock.newCondition();


    public void produce(String producer) {
        lock.lock();

        while (linkedList.size() == MAX_VALUE) {
            System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
            try {
                // 由于条件不满足，生产阻塞,通过condition进行触发
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        linkedList.add(new Object());
        System.out.println("【" + producer + "】：生产了一个产品\t【现仓储量为】:" + linkedList.size());
        empty.signalAll();

        lock.unlock();
    }

    public void consume(String consumer) {
        lock.lock();
        while (linkedList.size() == 0) {
            System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        linkedList.remove();
        System.out.println("【" + consumer + "】：消费了一个产品\t【现仓储量为】:" + linkedList.size());
        full.signalAll();
        lock.unlock();
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
