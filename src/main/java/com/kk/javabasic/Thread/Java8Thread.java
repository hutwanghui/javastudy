package com.kk.javabasic.Thread;

/**
 * Created by msi- on 2018/6/23.
 */
public class Java8Thread {


    public static void main(String[] args) {
        Runnable r = () -> System.out.println("这是使用Lamada表达式实现Runable接口而创建的线程");
        Thread myThread = new Thread(() -> {
            System.out.println("这是使用Lamada表达式继承Thread类创建的线程");
        }, "myThreadByLamada");
        r.run();
        System.out.println("线程的名字：" + myThread.getName() + "\n线程状态：" + myThread.getState() + "\n线程ID：" + myThread.getId());
        myThread.start();
        System.out.println("线程的名字：" + myThread.getName() + "\n线程状态：" + myThread.getState() + "\n线程ID：" + myThread.getId());
    }
}

