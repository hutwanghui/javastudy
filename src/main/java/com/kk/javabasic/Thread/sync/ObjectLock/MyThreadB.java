package com.kk.javabasic.Thread.sync.ObjectLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyThreadB extends Thread {
    private MyService myService;

    public MyThreadB(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        super.run();
//        myService.methodA();
//        myService.methodB();
        myService.methodC();

    }
}
