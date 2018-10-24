package com.kk.javabasic.Extends;

/**
 * Created by hutwanghui on 2018/9/24.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Father {

    public int id1;
    protected int id2;
    int id3;
    private int id4;

    public void test1() {
        System.out.println("public extends");
    }

    protected void test2() {
        System.out.println("protected extends");
    }

    void test3() {
        System.out.println("default extends");
    }

    private void test4() {
        System.out.println("private extends");
    }
}
