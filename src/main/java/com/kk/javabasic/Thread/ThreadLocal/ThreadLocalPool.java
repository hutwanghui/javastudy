package com.kk.javabasic.Thread.ThreadLocal;

import scala.Int;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hutwanghui on 2018/8/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ThreadLocalPool {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int count = 100;
        MyRunner myRunner = new MyRunner();
        for (int i = 0; i < 110; i++) {
            //模拟100个请求
            executorService.execute(() -> {
                MySession mySession = new MySession();
                mySession.getSessionId().set((int) (Math.random() * 100));
                mySession.getSessionName().set("clent" + (int) (Math.random() * 100));
                System.out.println(Thread.currentThread().getName() + "用户" + mySession.getSessionName().get() + "下单:编号" + mySession.getSessionId().get() + "剩余商品：");
            });
            count--;
            if (count == 0) {
                System.out.println("out!");
                break;
            }
        }


    }
}

class MyRunner implements Runnable {
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private volatile int count;

    public MyRunner() {

    }


    @Override
    public void run() {
        try {
            reentrantReadWriteLock.writeLock().lock();
            if (count > 0) {
                //模拟数据库插入
                // Thread.currentThread().sleep(100);
                count--;
            } else {
                //System.out.println("商品已经卖完");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

class MySession {
    private static final ThreadLocal<Integer> sessionId = new ThreadLocal<>();
    private static final ThreadLocal<String> sessionName = new ThreadLocal<>();
    private Integer money = 1000;
    private static final ThreadLocal<HashMap<String, Integer>> packages = new ThreadLocal<>();

    public ThreadLocal<HashMap<String, Integer>> getPackages() {
        return packages;
    }


    public ThreadLocal<Integer> getSessionId() {
        return sessionId;
    }

    public void reduce() {
        money--;
    }

    public ThreadLocal<String> getSessionName() {
        return sessionName;
    }


    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
