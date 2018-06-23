package com.kk.javabasic.Thread.sync.ObjectLock;

/**
 * Created by msi- on 2018/6/23.
 * 两个线程访问同一个对象的同一个同步方法=>A线程如果先持有object对象的Lock锁，B线程在调用不同的同步方法时需要等待
 * 两个线程访问同一个对象的不同同步方法=>A线程如果先持有object对象的Lock锁，B线程在调用不同的同步方法时需要等待
 * 两个线程访问同一个对象的一个是同步的方法，和一个非同步方法=>虽然线程A先持有类object对象的锁，但是线程B异步调用非同步方法不受影响
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA myThreadA = new MyThreadA(myService);
        MyThreadB myThreadB = new MyThreadB(myService);
        myThreadA.start();
        myThreadB.start();
    }
}
