package com.kk.javabasic.Thread.sync.BlockLock;

/**
 * Created by msi- on 2018/6/23.
 * 使用同步代码块，非代码块部分依旧是异步的，只有同步代码块部分是同步的
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThread myThread = new MyThread(myService);
        MyThread myThread1 = new MyThread(myService);
        myThread.start();
        myThread1.start();
    }
}
