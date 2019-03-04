package com.kk.javabasic.Interface;

/**
 * Created by hutwanghui on 2019/3/4.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class in01impl implements in01 {
    @Override
    public void test() {
        System.out.println("实现接口中未实现的方法！");
    }

    public static void main(String[] args) {
        in01 i = new in01impl();
        i.test();
        i.testImpl();
        System.out.printf("这是接口中定义的静态变量a：{}，静态常量b:{}", in01.b, in01.a);
//        in01.a=2;
//        in01.b=3;
        //会报错，因为在接口中的变量都是静态常量
    }

}
