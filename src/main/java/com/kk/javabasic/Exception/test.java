package com.kk.javabasic.Exception;

/**
 * Created by hutwanghui on 2018/9/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class test {
    void waitForSignal() {
        Object obj = new Object();
        synchronized (Thread.currentThread()) {
            try {

                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj.notify();
        }
    }

    public static void main(String[] args) {
        test t = new test();
        t.waitForSignal();
    }
}
