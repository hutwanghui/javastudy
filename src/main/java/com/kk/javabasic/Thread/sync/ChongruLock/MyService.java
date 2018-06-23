package com.kk.javabasic.Thread.sync.ChongruLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyService {
    synchronized public void methodD() {
        try {
            System.out.println("methodD方法开始：" + Thread.currentThread().getName());
            Thread.sleep(500);
            methodE();
            System.out.println("mehtodD方法结束：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodE() {
        try {
            System.out.println("methodE方法开始：" + Thread.currentThread().getName());
            Thread.sleep(500);
            System.out.println("mehtodE方法结束：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
