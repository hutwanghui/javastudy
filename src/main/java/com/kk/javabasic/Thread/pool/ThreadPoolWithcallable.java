package com.kk.javabasic.Thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future虽然可以实现获取异步执行结果的需求，但是它没有提供通知的机制，我们无法得知Future什么时候完成。
 * 推荐使用get (long timeout, TimeUnit_demo unit) 方法，设置了超时时间可以防止程序无限制的等待future的结果。
 */
public class ThreadPoolWithcallable implements Callable<String> {


    private int i;

    public ThreadPoolWithcallable(int i) {
        super();
        this.i = i;
    }

    @Override
    public String call() throws Exception {
        //Thread.currentThread().sleep(1000);
        return "当前" + i + "::" + Thread.currentThread().getName();
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            Future<String> submit = pool.submit(new ThreadPoolWithcallable(i));
            //结果需要等待线程执行结束=
            System.out.println(submit.get());
        }
        pool.shutdown();

    }

}
