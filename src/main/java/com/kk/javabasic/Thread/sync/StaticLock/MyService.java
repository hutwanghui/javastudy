package com.kk.javabasic.Thread.sync.StaticLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyService {
    synchronized public static void methodA() {
        try {
            System.out.println("static methodA方法开始：" + Thread.currentThread().getName());
            Thread.sleep(500);
            System.out.println("static mehtodA方法结束：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        try {
            System.out.println("非 static methodB方法开始：" + Thread.currentThread().getName());
            Thread.sleep(500);
            System.out.println("非 static mehtodB方法结束：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (MyService.class) {
            try {
                System.out.println("static methodB方法开始：" + Thread.currentThread().getName());
                Thread.sleep(500);
                System.out.println("static mehtodB方法结束：" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
