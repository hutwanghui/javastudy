package com.kk.javabasic.Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolWithRunable {


    /**
     * 通过线程池执行线程
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
//        public ThreadPoolExecutor(int corePoolSize,   线程池的基本大小
//                                  int maximumPoolSize,线程池最大线程大小
//                                  long keepAliveTime, 线程空闲后的存活时间
//                                  TimeUnit_demo unit,      同存活时间
//                                  BlockingQueue<Runnable> workQueue 存放任务的阻塞队列) {
//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor();

        for (int i = 1; i < 5; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread name: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.shutdown();
    }

}
