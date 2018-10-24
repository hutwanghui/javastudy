package com.kk.javabasic.sugar;

import java.util.Scanner;

/**
 * Created by hutwanghui on 2018/10/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 * 字符串的switch是通过equals()和hashCode()方法来实现的。
 * 还好hashCode()方法返回的是int。
 * String 反编译后实际上是一个hash值
 */
public class switchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        switch (str) {
            case "hello":
                System.out.println("case 情况1 你好");
                break;
            case "world":
                System.out.println("case 情况2 世界");
                break;
            default:
                System.out.println("hello world");
        }
    }
}
