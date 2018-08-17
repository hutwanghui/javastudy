package com.kk.javabasic.Design.Proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by msi- on 2018/6/21.
 */
public class Client {
    public static void main(String[] args) {
        MyService target = new MyServiceProxyImpl();

        InvocationHandler handler = new MyDynamicProxyHandler(target);

        MyService proxy = (MyService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);

        proxy.helloWorld();
        proxy.helloMaster("wanghui");
        String back = proxy.helloWorld_2();
        System.out.println("带有返回值的代理：" + back);

        MyService2 target2 = new MyServiceProxy2Impl();
        InvocationHandler handler2 = new MyDynamicProxyHandler(target2);


        MyService2 proxy2 = (MyService2) Proxy.newProxyInstance(
                target2.getClass().getClassLoader(),
                target2.getClass().getInterfaces(),
                handler2
        );

        proxy2.helloWorld2();
        proxy2.helloMaster2("wanghui");
        String back2 = proxy2.helloJava();
        System.out.println("带有返回值的代理：" + back2);


        // enhancer.setSuperClass() 设置需要增强的类
        // enhancer.setCallback() 则设置需要回调的拦截器，即实现了 MethodInterceptor 接口的类。
        // 最后最后使用 enhancer.create() 生成了对应的增强类
        //CGLib 生成新类的过程中，其使用的是一个名为 ASM 的东西，它对 Java 的 class 文件进行操作、生成新的 class 文件。
        MyDynamicProxyCGlib myDynamicProxyCGlib = new MyDynamicProxyCGlib();
        MyServiceProxy2Impl cglib = (MyServiceProxy2Impl) myDynamicProxyCGlib.getObject(MyServiceProxy2Impl.class);
        cglib.helloWorld2();
        cglib.helloMaster2("wanghui");

        System.out.println(String.valueOf(cglib.helloJava()));
    }
}
