package com.kk.javabasic.Java9;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Created by hutwanghui on 2018/10/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class FluxDemo {
    public static void main(String[] args) {
        Flux.just("Hello", "World")
                .map(str -> str.toUpperCase())
                .subscribe(System.out::println);
        Flux.fromArray(new Integer[]{1, 2, 3})
                .map(i -> ++i)
                .subscribe(System.out::println);
        Flux.empty()
                .subscribe(System.out::println);
        Flux.range(1, 10)
                .map(i -> {
                    if (i % 2 == 0) {
                        return i;
                    }
                    return 0;
                    //throw new RuntimeException("该数字非偶数");
                })
                .subscribe(i -> System.out.println(i)
                        , error -> System.err.println("Error:" + error)
                        , () -> System.out.println("mission has done")
                        , sub -> sub.request(10));
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS))
                .subscribe(System.out::println);
    }
}
