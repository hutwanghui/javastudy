package com.kk.javabasic.Thread.sync.StaticLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyThreadA extends Thread {

    @Override
    public void run() {
        super.run();
        MyService.methodA();
    }
}
