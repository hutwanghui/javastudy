package com.kk.javabasic.Thread.sync.StaticLock;

/**
 * Created by msi- on 2018/6/23.
 * class锁可以对类的所有对象实例上锁
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadB myThreadB_1 = new MyThreadB(myService);
        MyThreadB myThreadB_2 = new MyThreadB(myService);
        MyThreadB myThreadB_3 = new MyThreadB(myService);
        MyThreadA myThreadA_1 = new MyThreadA();
        MyThreadA myThreadA_2 = new MyThreadA();
        myThreadB_1.start();
        myThreadB_2.start();
        myThreadB_3.start();
        myThreadA_1.start();
        myThreadA_2.start();
    }

    ;
}
