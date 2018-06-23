package com.kk.javabasic.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by msi- on 2018/6/21.
 */
public class Client {
    public static void main(String[] args) {
        MyService target = new MyServiceImpl();

        InvocationHandler handler = new MyDynamicProxyHandler(target);

        MyService proxy = (MyService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);

        proxy.helloWorld();
        proxy.helloMaster("wanghui");
        String back = proxy.helloWorld_2();
        System.out.println("带有返回值的代理：" + back);
    }
}
