package com.kk.javabasic.Thread.sync.ChongruLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyThreadB extends Thread {
    private MyService_Son myService;

    public MyThreadB(MyService_Son myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        super.run();
        myService.methodA();
//        myService.methodB();

    }
}
