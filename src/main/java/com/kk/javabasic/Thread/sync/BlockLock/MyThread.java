package com.kk.javabasic.Thread.sync.BlockLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyThread extends Thread {
    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        super.run();
        myService.methodA();
    }
}
