package com.kk.javabasic.Java9;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import scala.reflect.internal.SymbolsStats;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by hutwanghui on 2018/10/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ReactorDemo {
    public static void main(String[] args) {
        Flux.fromArray(new String[]{"Monday", "Tuesday", "Wednesday"})
                .subscribe(System.out::println);
            Flux<Long> flux = Flux.interval(Duration.ofMillis(1))
                .doOnNext(e -> {
                    System.out.println(e);
                }).doOnError(e -> e.printStackTrace());

        System.out.println("Begin to Subscribe");
        Disposable subscribe = flux.subscribe(e -> {
            System.out.println(e);
            try {
                TimeUnit.MINUTES.sleep(30);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        });
    }
}
