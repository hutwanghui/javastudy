package com.kk.javabasic.Java9;

import java.util.concurrent.Flow;

/**
 * Created by hutwanghui on 2018/9/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MySubscriber<T> implements Flow.Subscriber<T> {

    public Flow.Subscription subscription;

    //调用来确认注册，它接收一个subscription作为参数
    //subscription的方法允许向发布者请求新的数据，也可以请求发布者不再发送数据。
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;

        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        System.out.println("Received:" + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        synchronized ("A") {
            "A".notifyAll();
        }

    }

    @Override
    public void onComplete() {
        System.out.println("Done");
        synchronized ("A") {
            "A".notifyAll();
        }

    }
}
