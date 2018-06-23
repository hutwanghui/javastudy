package com.kk.javabasic.Thread.sync.ObjectLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyService {
    private int num;

    //方法A\B的区别就在于对象锁
    public void methodA() {
        try {
            System.out.println("methodA方法开始：" + Thread.currentThread().getName());
            Thread.sleep(500);
            System.out.println("mehtodA方法结束：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB() {
        try {
            System.out.println("methodB方法开始：" + Thread.currentThread().getName());
            Thread.sleep(500);
            System.out.println("mehtodB方法结束：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized public void methodC() {
        try {
            System.out.println("methodC方法开始：" + Thread.currentThread().getName());
            Thread.sleep(500);
            System.out.println("mehtodC方法结束：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
