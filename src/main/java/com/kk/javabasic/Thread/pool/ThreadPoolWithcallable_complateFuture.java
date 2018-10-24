package com.kk.javabasic.Thread.pool;

import java.util.concurrent.*;

public class ThreadPoolWithcallable_complateFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            Future<String> submit = pool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    //System.out.println("a");
                    Thread.sleep(1000);
                    return Thread.currentThread().getName();
                }
            });
            //结果需要等待线程执行结束
            System.out.println(submit.get());
        }
        pool.shutdown();

    }

}
