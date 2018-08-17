package com.kk.javabasic.Design.Proxy.Static;

import com.kk.javabasic.Design.Proxy.dynamic.MyService;

/**
 * Created by hutwanghui on 2018/8/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class client {
    public static void main(String[] args) {
        MyService_Static service=new MyProxyImpl();
        service.helloWorld();
        service.helloMaster("wanghui");
        System.out.println(service.helloJava());
    }
}
