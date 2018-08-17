package com.kk.javabasic.Design.Proxy.dynamic;

/**
 * Created by msi- on 2018/6/21.
 */
//目标类
public class MyServiceProxyImpl implements MyService {

    @Override
    public void helloWorld() {
        System.out.println("Hello World");
    }

    @Override
    public void helloMaster(String master) {
        System.out.println("Hello " + master);
    }

    @Override
    public String helloWorld_2() {
        return "Hello Java";
    }
}
