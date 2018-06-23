package com.kk.javabasic.Thread;

/**
 * Created by msi- on 2018/6/21.
 */
public class test {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("Hello");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                        break;
                    }
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted2");
        }
        t.interrupt();
    }
}
