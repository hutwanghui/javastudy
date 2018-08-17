package com.kk.javabasic.Thread;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ThreadNotifAndWait implements Runnable {
    private Service service = new Service();

    @Override
    public void run() {
//        service.testStaticLock();
        service.testObjectLock();
    }

    public static void main(String[] args) {
        ThreadNotifAndWait threadNotifAndWait = new ThreadNotifAndWait();
        Thread thread = new Thread(threadNotifAndWait);
        Thread thread1 = new Thread(threadNotifAndWait);
        Thread thread2 = new Thread(threadNotifAndWait);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class Service {
    private static int i;
    private int j;

    public static synchronized void testStaticLock() {
        i++;
        System.out.println(Thread.currentThread().getName() + "对I进行类锁操作" + i);
    }

    public synchronized void testObjectLock() {
        j++;
        System.out.println(Thread.currentThread().getName() + "对J进行类锁操作" + j);
    }

    public synchronized void testNotifyAndWait() {

    }
}