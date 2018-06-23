package com.kk.javabasic.Thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by msi- on 2018/6/23.
 * Condition:对象监视器
 * JDK1.5新增，用于线程间的等待/通知，相当于wait()-notify()
 * 具有多路通知功能，也就是说，在一个Lock对象里面可以创建多个Condition，通过将线程对象注册在监视器里，进行选择性的线程通知(以前是jvm随机选择的)，调度更加灵活
 */
public class MyCondition {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println(">>>>>>>>监视器获得锁>>>>>>>");
            condition.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(">>>>>>>>监视器释放锁>>>>>>>");
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println(">>>>>>>>signal获得锁>>>>>>>");
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyCondition myCondition = new MyCondition();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "执行...." + i);
                myCondition.await();
            }
        }, "MyThread_1").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "执行...." + i);
                myCondition.await();
            }
        }, "MyThread_2").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "执行...." + i);
                myCondition.await();
            }
        }, "MyThread_3").start();
        myCondition.signal();
    }
}
