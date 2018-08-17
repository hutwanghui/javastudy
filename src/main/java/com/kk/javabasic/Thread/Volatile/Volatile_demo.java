package com.kk.javabasic.Thread.Volatile;

/**
 * Created by hutwanghui on 2018/8/9.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Volatile_demo implements Runnable {

    private boolean isStop = true;

    @Override
    public void run() {
        while (isStop) {
            System.out.println("======");
        }
    }

    public static void main(String[] args) {
        Volatile_demo volatile_demo = new Volatile_demo();
        Thread thread = new Thread(volatile_demo);
        thread.start();
        volatile_demo.isStop = false;
    }
}
