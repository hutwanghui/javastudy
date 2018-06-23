package com.kk.javabasic.Thread.sync.StaticLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyThreadB extends Thread {
    private MyService myService;

    public MyThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        super.run();
        myService.methodB();
    }
}
