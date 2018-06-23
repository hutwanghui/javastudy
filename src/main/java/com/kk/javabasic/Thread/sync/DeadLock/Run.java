package com.kk.javabasic.Thread.sync.DeadLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        DeadThread deadThread = new DeadThread();
        deadThread.setFlag("a");
        Thread myThread1 = new Thread(deadThread);
        myThread1.start();
        Thread.sleep(100);
        deadThread.setFlag("b");
        Thread myThread2 = new Thread(deadThread);
        myThread2.start();
    }
}
