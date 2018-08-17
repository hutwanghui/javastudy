package com.kk.javabasic.Design.Proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by hutwanghui on 2018/8/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MyDynamicProxyCGlib implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getObject(Class clazz) {
        //设置创建子类的类,即指定为哪个类产生代理类

        enhancer.setSuperclass(clazz);
        //设置回调函数 * setCallback设置被代理类的public非final方法被调用时的处理类
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        methodProxy.invokeSuper(o, args);
        System.out.println("使用cglib进行代理");
        return o;
    }
}
