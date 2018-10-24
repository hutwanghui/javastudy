package com.kk.javabasic.Thread.pool;

import java.sql.SQLOutput;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by hutwanghui on 2018/9/25.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ThreadPoolServiceDemo {
    // 线程池维护线程的最少数量
    private final static int CORE_POOL_SIZE = 2;
    // 线程池维护线程的最大数量
    private final static int MAX_POOL_SIZE = 6;
    // 线程池维护线程所允许的空闲时间
    private final static int KEEP_ALIVE_TIME = 0;
    // 线程池所使用的缓冲队列大小
    private final static int WORK_QUEUE_SIZE = 50;

    static final RejectedExecutionHandler handler = new RejectedExecutionHandler() {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("拒绝策略");
        }
    };

    static class MyRunner implements Runnable {

        @Override
        public void run() {
            System.out.println("泡泡");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE
                , MAX_POOL_SIZE
                , KEEP_ALIVE_TIME
                , TimeUnit.SECONDS, new ArrayBlockingQueue<>(WORK_QUEUE_SIZE), handler);
        for (int i = 0; i < 100; i++) {
            executor.submit(new MyRunner());
        }

    }

}
