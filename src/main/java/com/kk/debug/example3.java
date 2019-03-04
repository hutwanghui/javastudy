package com.kk.debug;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hutwanghui on 2019/2/3.
 * email:zjjhwanhui@163.com
 * qq:472860892
 * 线程调试技巧
 * 将suspend从All更改为Thread
 */
public class example3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable r1 = () -> {
            System.out.println("当前线程 :" + Thread.currentThread().getName());
            System.out.println("多线程Debug ========= 001 =========");
        };

        Runnable r2 = () -> {
            System.out.println("当前线程 :" + Thread.currentThread().getName());
            System.out.println("多线程Debug ========= 002 =========");
        };

        Runnable r3 = () -> {
            System.out.println("当前线程 :" + Thread.currentThread().getName());
            System.out.println("多线程Debug ========= 003 =========");
        };

        executorService.execute(r1);
        executorService.execute(r2);
        executorService.execute(r3);


        System.out.println("多线程线程池调用结束");
        executorService.shutdown();
    }
}
