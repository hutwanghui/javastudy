package com.kk.javabasic.Java9;

import java.util.concurrent.Flow;

/**
 * Created by hutwanghui on 2018/9/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MyPublisher<T> implements Flow.Publisher<T> {
    @Override
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        System.out.println("注册订阅者~");
    }

}
