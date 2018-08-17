package com.kk.javabasic.Thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class CyclicBarrier_demo {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                //当四个线程都到达barrier状态后，会从四个线程中选择一个线程去执行Runnable。
                System.out.println(Thread.currentThread().getName() + "完成写入任务后进行的操作");
            }
        });
        for (int i = 0; i < N; i++) {
            new Thread(() -> {
                System.out.println("当前线程:" + Thread.currentThread().getName() + "正在写入。。。。");
                try {
                    //用于模拟写入IO的耗时
                    Thread.sleep(5000);
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "写入完成");
                    //会抛出BrokenBarroerException
                    //if (Thread.currentThread().getName().equals("Thread-1")) {
//                        cyclicBarrier.reset();
//                    }
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("所有线程写入完毕，继续处理其他任务...");
            }).start();

        }
    }
}
