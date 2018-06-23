package com.kk.javabasic.Thread.sync.BlockLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyService {
    public void methodA() {
        try {
            System.out.println("进入方法，非同步部分：" + System.currentTimeMillis());
            Thread.sleep(8000);
            synchronized (this) {
                System.out.println("同步开始：" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("同步结束: " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("离开方法，非同步部分：" + System.currentTimeMillis());
    }
}
