package com.kk.javabasic.Thread.sync.ChongruLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyThreadA extends Thread {
    private MyService myService;

    public MyThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        super.run();
        myService.methodD();
    }
}
