package com.kk.javabasic.Design.Proxy.Static;

/**
 * Created by hutwanghui on 2018/8/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MyServiceImpl implements MyService_Static {

    @Override
    public void helloWorld() {
        System.out.println("hello World");
    }

    @Override
    public void helloMaster(String master) {
        System.out.println("hello "+master);
    }

    @Override
    public String helloJava() {
        return "hello Java";
    }
}
