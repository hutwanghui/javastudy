package com.kk.javabasic.Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolWithRunable_java8 {


    /**
     * 通过线程池执行线程
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 1; i < 5; i++) {
            pool.execute(() -> {
                System.out.println("thread name: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
    }

}
