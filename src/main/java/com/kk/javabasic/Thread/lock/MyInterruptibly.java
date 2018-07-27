package com.kk.javabasic.Thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyInterruptibly {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        MyInterruptibly test = new MyInterruptibly();
        MyThread thread0 = new MyThread(test);
        MyThread thread1 = new MyThread(test);
        thread0.start();
        thread1.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();
        System.out.println("=====================");
    }

    public void insert(Thread thread) throws InterruptedException {
        System.out.println("我是没有上锁的部分！！！");
        lock.lockInterruptibly();   //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                //System.out.println(Thread.currentThread().getName() + "正在执行");
                if (System.currentTimeMillis() - startTime >= 100) {

                    break;
                }
                //插入数据
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }
}

class MyThread extends Thread {
    private MyInterruptibly test = null;

    public MyThread(MyInterruptibly test) {
        this.test = test;
    }

    @Override
    public void run() {

        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断" + e.getLocalizedMessage());
        }
    }

}
