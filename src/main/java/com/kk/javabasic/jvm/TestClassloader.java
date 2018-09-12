package com.kk.javabasic.jvm;

/**
 * Created by hutwanghui on 2018/8/23.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class TestClassloader {
    public void hello() {
        System.out.println("恩，是的，我是由 " + getClass().getClassLoader().getClass()
                + " 加载进来的");
    }
}
