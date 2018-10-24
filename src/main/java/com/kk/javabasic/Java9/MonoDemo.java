package com.kk.javabasic.Java9;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * Created by hutwanghui on 2018/10/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MonoDemo {
    public static void main(String[] args) {
        Mono.fromSupplier(() -> "hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
    }
}
