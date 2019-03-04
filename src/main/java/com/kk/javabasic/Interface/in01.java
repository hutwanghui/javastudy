package com.kk.javabasic.Interface;

/**
 * Created by hutwanghui on 2018/9/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public interface in01 {

    public void test();

    default public void testImpl() {
        System.out.println("这是JAVA1.8以后可以在接口中定义的方法");
    }

    public static int a = 1;

    public static final int b = 1;

}
