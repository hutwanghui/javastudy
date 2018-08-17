package com.kk.javabasic.Thread.Hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

import java.util.List;

/**
 * Created by hutwanghui on 2018/7/31.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * observable与普通的Command的区别：
 * 普通的Command是由新创建的线程执行，且run只能返回一个String结果
 * observable是由调度程序线程执行。实现了向调用程序发送多条数据
 * 基于发布-订阅响应式的调用，本质上是观察者模式的一种具体实现。
 */
public class DingdanService_Observable extends HystrixObservableCommand<List<Order>> {

    private List<Order> orders;

    public DingdanService_Observable(List<Order> orders) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("OBSERVABLE")));
        this.orders = orders;
    }

    @Override
    protected Observable<List<Order>> construct() {
        return null;
    }
}
