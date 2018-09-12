package com.kk.javabasic.javaWeb;

import org.apache.coyote.http11.Http11Protocol;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hutwanghui on 2018/8/23.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class bootStrap {
    public static void main(String[] args) throws Exception {
        Http11Protocol http11Protocol = new Http11Protocol();
        http11Protocol.setPort(8888);
        ThreadPoolExecutor threadPoolExecutor = createThreadPoolExecutor();
        threadPoolExecutor.prestartCoreThread();
        http11Protocol.setExecutor(threadPoolExecutor);
        http11Protocol.setAdapter(new MyAdapter());
        http11Protocol.init();
        http11Protocol.start();

        System.out.println("My WebServer has Started successfully");
    }

    public static ThreadPoolExecutor createThreadPoolExecutor() {
        int corePoolSite = 2;
        int maxPoolSite = 10;
        long keepAliveTime = 60;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(corePoolSite, maxPoolSite,
                        keepAliveTime, unit, workQueue);
        return threadPoolExecutor;
    }
}
