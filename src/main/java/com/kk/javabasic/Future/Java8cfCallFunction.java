package com.kk.javabasic.Future;

import java.util.concurrent.CompletableFuture;

/**
 * Created by hutwanghui on 2018/9/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Java8cfCallFunction {
    public static void main(String[] args) {
        //当前阶段的执行的结果会作为下一阶段的输入参数
        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(i -> i + 1)
                .thenApply(i -> i * i)
                .whenComplete((r, e) -> System.out.println(r));

        //联合
        CompletableFuture.supplyAsync(() -> "hello")
                .thenApply(s -> s + "World")
                .thenApply(String::toUpperCase)
                .thenCombine(CompletableFuture.completedFuture("Java"), (s1, s2) -> s1 + s2)
                .thenAccept(System.out::println);

        //结果不会作为下一阶段的输入参数
        CompletableFuture.supplyAsync(() -> "hello")
                .thenAccept(s -> s.toString())
                .thenAccept(s -> System.out.println(s + "world"));

        //不需要输入参数
        CompletableFuture.supplyAsync(() -> "hello")
                .thenRun(System.out::println);
    }
}
