package com.kk.javabasic.Thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hutwanghui on 2018/8/5.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MyFairLock {
    private ReentrantLock reentrantLock = new ReentrantLock(true);

    public void methodA() {
        try {
            reentrantLock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName：" + Thread.currentThread().getName() + " ： " + (i + 1));
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "锁释放");
            reentrantLock.unlock();
        }
    }


    public static void main(String[] args) {
        MyFairLock myLock = new MyFairLock();
        Thread thread_1 = new Thread(() -> {
            myLock.methodA();
        }, "线程1");
        Thread thread_2 = new Thread(() -> {
            myLock.methodA();
        }, "线程2");
        Thread thread_3 = new Thread(() -> {
            myLock.methodA();
        }, "线程3");
        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}
