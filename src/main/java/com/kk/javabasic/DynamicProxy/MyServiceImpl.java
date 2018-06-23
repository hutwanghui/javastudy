package com.kk.javabasic.DynamicProxy;

/**
 * Created by msi- on 2018/6/21.
 */
public class MyServiceImpl implements MyService {
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
