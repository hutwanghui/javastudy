package com.kk.javabasic.Thread.sync.ChongruLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyService_Son extends MyService {
    synchronized public void methodA() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "子类同步方法调用父类的同步方法");
                this.methodD();
            }
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("子类非同步方法调用父类的同步方法");
                this.methodD();
            }
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
