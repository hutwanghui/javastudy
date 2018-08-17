package com.kk.javabasic.Thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyLock {
    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName：" + Thread.currentThread().getName() + " ： " + (i + 1));
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "锁释放");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
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
