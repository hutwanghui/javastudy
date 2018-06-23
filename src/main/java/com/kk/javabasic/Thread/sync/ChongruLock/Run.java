package com.kk.javabasic.Thread.sync.ChongruLock;


/**
 * Created by msi- on 2018/6/23.
 * 在一个同步方法/块内部调用本线程类的其他同步方法/块=>只要方法链是同步的永远都同步
 * 父子类继承关系中子类通过可重入锁调用父类的同步方法（子、父类的方法需要都是有关键字声明因为同步不具有继承性）
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA myThreadA = new MyThreadA(myService);
        MyService_Son myService_son = new MyService_Son();
        MyThreadB myThreadB = new MyThreadB(myService_son);
        MyThreadB myThreadB1 = new MyThreadB(myService_son);
//        myThreadA.start();
        myThreadB.start();
        myThreadB1.start();
    }
}
