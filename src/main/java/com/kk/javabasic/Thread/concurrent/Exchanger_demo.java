package com.kk.javabasic.Thread.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hutwanghui on 2018/8/9.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Exchanger_demo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        final Exchanger exchanger = new Exchanger();
        executor.execute(new Runnable() {
            String data1 = "克拉克森，小拉里南斯";


            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });


        executor.execute(new Runnable() {
            String data1 = "格里芬";

            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });

        executor.execute(new Runnable() {
            String data1 = "哈里斯";

            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });

        executor.execute(new Runnable() {
            String data1 = "以赛亚托马斯，弗莱";

            @Override
            public void run() {
                nbaTrade(data1, exchanger);
            }
        });

        executor.shutdown();
    }

    private static void nbaTrade(String data1, Exchanger exchanger) {
        try {
            System.out.println(Thread.currentThread().getName() + "在交易截止之前把 " + data1 + " 交易出去");
            Thread.sleep((long) (Math.random() * 1000));

            String data2 = (String) exchanger.exchange(data1);
            System.out.println(Thread.currentThread().getName() + "交易得到" + data2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
