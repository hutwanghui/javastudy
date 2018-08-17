package com.kk.javabasic.fanxing;

/**
 * Created by hutwanghui on 2018/8/1.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Number_Demo<T extends Number> {
    T num;

    public Number_Demo(T num) {
        this.num = num;
    }

    double GetDoubleNum() {
        //如果没有extends Number，那么就会报错
        return this.num.doubleValue();
    }

    public static void main(String[] args) {
        Number_Demo<Integer> number_demo = new Number_Demo<>(1);
        System.out.println(number_demo.GetDoubleNum());
    }

}
