package com.kk.debug;

/**
 * Created by hutwanghui on 2019/2/3.
 * email:zjjhwanhui@163.com
 * qq:472860892
 * 循环调试技巧
 */
public class example2 {

    public static void execute(int num) {
        System.out.println("execute: " + num);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            execute(i);
        }
    }
}
