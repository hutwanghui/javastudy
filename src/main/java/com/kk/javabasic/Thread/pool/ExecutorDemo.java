package com.kk.javabasic.Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;


public class ExecutorDemo {

    public static void main(String[] args) {
        //SingleThreadExecutor()只有一个线程的线程池，这样创建的线程池所有提交的任务都是顺序执行的
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        //CahedThreadPool,无限制线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println(cpuNums);
        //创建固定线程数量的线程池，如果没有任务执行，会一直等待
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(cpuNums);
        //用于调度即将执行任务的线程池，即有时间限制的线程池
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(8);
        //单线程的调度线程池
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();



    }
}
