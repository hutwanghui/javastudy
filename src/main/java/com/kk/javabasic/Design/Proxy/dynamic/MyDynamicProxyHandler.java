package com.kk.javabasic.Design.Proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by msi- on 2018/6/21.
 */
//代理类
public class MyDynamicProxyHandler implements InvocationHandler {
    //这就是需要代理的真实对象
    private Object subject;

    public MyDynamicProxyHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("<<<<<<<<<在代理之前做的动作<<<<<<<<<");
        System.out.println("===========被代理的方法：" + method.getName() + "=========");
        //    当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        Object result = method.invoke(subject, args);
        System.out.println(">>>>>>>>>在代理之后做的动作>>>>>>>");
        return result;
    }
}
