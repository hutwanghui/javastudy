package com.kk.javabasic.Thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 可重入锁，jdk1.5新增，能达到和synchronized相同的小果果，并且多了嗅探锁定，多路分支通知的功能，比synchronized灵活
 */
public class MyReentrantReadWriteLock {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final MyReentrantReadWriteLock test = new MyReentrantReadWriteLock();

        new Thread() {
            public void run() {
                test.get(Thread.currentThread());
            }

            ;
        }.start();

        new Thread() {
            public void run() {
                test.get(Thread.currentThread());
            }

            ;
        }.start();

    }

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }

}
