package com.kk.javabasic.Thread.sync;

/**
 * Created by msi- on 2018/6/23.
 */
public class WaitAndNotify extends Thread {
    class Shared {
        private volatile boolean writable = true;
        private int num;

        synchronized void addSharedNum(int num) {

        }
    }

    private int num;

}
