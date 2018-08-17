package com.kk.javabasic.Thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class CountDownLatch_demo {
    public static void main(String[] args) throws InterruptedException {

        // 新建一个CountDownLatch，并指制定一个初始大小,3就需要等待三个线程都执行完，2只需要等待两个
        CountDownLatch countDownLatch = new CountDownLatch(3) {
            @Override
            public void await() throws InterruptedException {
                super.await();
                System.out.println(Thread.currentThread().getName() + " count down is ok");
            }
        };


        //thread1
        // do something
        new Thread(() -> {
            System.out.println("线程1正在进行工作~~~");
            //调用countDown方法，将计数减1
            //countDownLatch.countDown();
        }, "Thread1").start();


        //thread2
        // do something
        new Thread(() -> {
            System.out.println("线程2正在进行工作~~~");
            //调用countDown方法，将计数减1
            countDownLatch.countDown();
        }, "Thread2").start();


        //thread3
        // do something
        new Thread(() -> {
            System.out.println("线程3正在进行工作~~~");
            //调用countDown方法，将计数减1
            countDownLatch.countDown();
        }, "Thread3").start();


        countDownLatch.await();
        System.out.println("after await");
    }
}
