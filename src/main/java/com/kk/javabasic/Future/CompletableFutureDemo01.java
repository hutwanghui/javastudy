package com.kk.javabasic.Future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static java.lang.Thread.sleep;

/**
 * Created by hutwanghui on 2018/9/11.
 * email:zjjhwanhui@163.com
 * qq:472860892
 * 运行一个异步的stage
 */

public class CompletableFutureDemo01 {
    public static void main(String[] args) {
        System.out.println("main thread: " + Thread.currentThread());

        new Thread(CompletableFutureDemo01::test1) {{
            setName("my-new-thread");
        }}.start();

//        test2();
    }

    private static void test1() {

        CompletionStage<Void> futurePrice = CompletableFuture.runAsync(() -> {
                    System.out.println("test1:1 - runAsync(runnable), job thread: " + Thread.currentThread());
                }
        );
        System.out.println("test1:flag1");
        futurePrice.thenRun(() -> {
            System.out.println("test1:2 - thenRun(runnable)), action thread: " + Thread.currentThread());
        });
        System.out.println("test1:flag2");
        futurePrice.thenRunAsync(() -> {
            System.out.println("test1:3 - thenRunAsync(runnable), action thread: " + Thread.currentThread());
        });

    }
}
