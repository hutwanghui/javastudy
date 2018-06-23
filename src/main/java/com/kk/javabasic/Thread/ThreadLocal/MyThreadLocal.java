package com.kk.javabasic.Thread.ThreadLocal;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyThreadLocal {
    //初始化ThreadLocal并将其引用赋值给一个volatile的类属性userUd
    //volatile的申明原因：这个属性可能会运行在多核处理器伤感，被多条线程访问
    private static volatile ThreadLocal<String> userId = new ThreadLocal<String>();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            if (name.equals("a")) {
                userId.set("Wanghui_A");
            } else {
                userId.set("Wanghui_B");
            }
            System.out.println(name + " : " + userId.get());
        };
        Thread thread_1 = new Thread(runnable);
        thread_1.setName("a");
        Thread thread_2 = new Thread(runnable);
        thread_2.setName("b");
        thread_1.start();
        thread_2.start();
    }
}
