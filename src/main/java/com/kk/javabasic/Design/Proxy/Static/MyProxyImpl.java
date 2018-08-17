package com.kk.javabasic.Design.Proxy.Static;

/**
 * Created by hutwanghui on 2018/8/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MyProxyImpl implements MyService_Static {

    private MyServiceImpl myService = new MyServiceImpl();

    @Override
    public void helloWorld() {
        System.out.println("<<<<<<<<<<<在代理之前做的动作<<<<<<<<<<");
        myService.helloWorld();
        System.out.println(">>>>>>>>>>>在代理之后做的动作>>>>>>>>>>");
    }

    @Override
    public void helloMaster(String master) {
        System.out.println("<<<<<<<<<<<在代理之前做的动作<<<<<<<<<<");
        myService.helloMaster(master);
        System.out.println(">>>>>>>>>>>在代理之后做的动作>>>>>>>>>>");
    }

    @Override
    public String helloJava() {
        System.out.println("<<<<<<<<<<<在代理之前做的动作<<<<<<<<<<");
        System.out.println(">>>>>>>>>>>在代理之后做的动作>>>>>>>>>>");
        return myService.helloJava();
    }
}
