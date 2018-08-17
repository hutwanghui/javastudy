package com.kk.javabasic.Thread.sync.DeadLock;

/**
 * Created by msi- on 2018/6/23.
 */
public class DeadThread implements Runnable {
    public String username;
    public Object lock1 = new Object();
    public Object lock2 = new Object();

    public void setFlag(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        if (username.equals("a")) {
            synchronized (lock1) {
                try {
                    System.out.println(Thread.currentThread().getName() + "进入lock1代码块" + "username=" + username);
                    Thread.sleep(3000);
                    System.out.println("等待lock2资源......");
                    synchronized (lock2) {
                        System.out.println("lock1->lock2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        if (username.equals("b")) {
            synchronized (lock2) {
                try {
                    System.out.println(Thread.currentThread().getName() + "进入lock2代码块" + "username=" + username);
                    Thread.sleep(3000);
                    System.out.println("等待lock1资源......");
                    synchronized (lock1) {
                        System.out.println("lock2->lock1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadThread deadThread = new DeadThread();
        deadThread.setFlag("a");
        Thread myThread1 = new Thread(deadThread);
        myThread1.start();
        Thread.sleep(100);
        deadThread.setFlag("b");
        Thread myThread2 = new Thread(deadThread);
        myThread2.start();
    }
}
