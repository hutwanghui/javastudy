package com.kk.javabasic.Java9;

import java.util.concurrent.Flow;

/**
 * Created by hutwanghui on 2018/9/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MySubscription implements Flow.Subscription {
    @Override
    public void request(long n) {
        if(n>=5){
            return;
        }
    }

    @Override
    public void cancel() {

    }
}
