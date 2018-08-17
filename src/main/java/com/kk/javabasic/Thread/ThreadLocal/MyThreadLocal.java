package com.kk.javabasic.Thread.ThreadLocal;

/**
 * Created by msi- on 2018/6/23.
 */
public class MyThreadLocal {
    //初始化ThreadLocal并将其引用赋值给一个volatile的类属性userUd
    //volatile的申明原因：这个属性可能会运行在多核处理器伤感，被多条线程访问
    private static volatile ThreadLocal<String> userId = new ThreadLocal<String>();

    public static void main(String[] args) {
        //同一份ThreadLocalClass
        final ThreadLocalClass threadLocalClass = new ThreadLocalClass();
        Runnable runnable = () -> {
            //set Key
            threadLocalClass.getThreadLocal().set((int) (Math.random() * 100));
            //set Value（这个就相当于非现场隔离的对象）
            threadLocalClass.setValue((int) (Math.random() * 100));
            threadLocalClass.getThreadLocal_str().set("kkk" + Math.random() * 100);
            System.out.println(Thread.currentThread().getName() + " " + " 线程共有的: " + threadLocalClass.getValue() + "线程私有的:" + threadLocalClass.getThreadLocal().get() + ":" + threadLocalClass.getThreadLocal_str().get());
            threadLocalClass.getThreadLocal().remove();
            System.out.println(Thread.currentThread().getName() + " " + " 线程共有的: " + threadLocalClass.getValue() + "线程私有的:" + threadLocalClass.getThreadLocal().get() + ":" + threadLocalClass.getThreadLocal_str().get());

        };
        Thread thread_1 = new Thread(runnable);
        Thread thread_2 = new Thread(runnable);
        thread_1.start();
        thread_2.start();
    }
}

class ThreadLocalClass {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private ThreadLocal<String> threadLocal_str = new ThreadLocal<>();
    private Integer value = 0;

    public ThreadLocal<Integer> getThreadLocal() {
        return threadLocal;
    }

    public void setThreadLocal(ThreadLocal<Integer> threadLocal) {
        this.threadLocal = threadLocal;
    }

    public ThreadLocal<String> getThreadLocal_str() {
        return threadLocal_str;
    }

    public void setThreadLocal_str(ThreadLocal<String> threadLocal_str) {
        this.threadLocal_str = threadLocal_str;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
