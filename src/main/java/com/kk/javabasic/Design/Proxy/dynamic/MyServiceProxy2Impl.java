package com.kk.javabasic.Design.Proxy.dynamic;

/**
 * Created by hutwanghui on 2018/8/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MyServiceProxy2Impl implements MyService2 {
    @Override
    public void helloWorld2() {
        System.out.println("hello2 World2");
    }

    @Override
    public void helloMaster2(String master) {
        System.out.println("hello2 " + master);
    }

    @Override
    public String helloJava() {
        return "hello2 Java2";
    }
}
