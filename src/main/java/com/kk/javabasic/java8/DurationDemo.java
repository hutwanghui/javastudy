package com.kk.javabasic.java8;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by hutwanghui on 2018/10/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class DurationDemo {
    public static void main(String[] args) {
        Instant first = Instant.now();
        System.out.println(first);
        Instant second = Instant.now();
        System.out.println(second);
        Duration duration = Duration.between(first, second);
        System.out.println(duration);
        long seconds = duration.toSeconds();
        System.out.println("Duration转换成秒钟值：" + seconds);
        int nanos = duration.getNano();
        System.out.println("Duration获取纳秒值：" + nanos);
    }

}
