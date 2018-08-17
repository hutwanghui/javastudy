package com.kk.javabasic.Thread.concurrent;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import java.util.concurrent.TimeUnit;

/**
 * 使线程安全停止
 */
public class ThreadSafeStop {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runner(), "OneThread");
        thread.start();
        // 中断被阻塞状态（sleep、wait、join 等状态）的线程，会抛出异常 InterruptedException
        //不安全的停止方法
        thread.interrupt();

        Runner runner = new Runner();
        thread = new Thread(runner, "TwoThread");
        thread.start();
        //TimeUnit可以让当前线程睡眠
        TimeUnit.SECONDS.sleep(5);
        //不会抛异常
        runner.stopSafety();
    }

    public static class Runner implements Runnable {

        private long i = 0;

        //终止状态，使用volatile使得（强制从公共堆栈中取值）
        private volatile boolean on = true;

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (on && !Thread.currentThread().isInterrupted()) {
                //具体的业务逻辑代码
                i++;
            }
            System.out.println(Thread.currentThread().getName() + "执行了" + i);
        }

        public void stopSafety() {
            on = false;
        }
    }
}
