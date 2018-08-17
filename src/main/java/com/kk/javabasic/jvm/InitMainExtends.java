package com.kk.javabasic.jvm;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
class Parent {
    static {
        System.out.println("static Parent init");
    }
    Parent(){
        System.out.println("Construct Parent init");
    }
    public static int v = 100;
}

class Child extends Parent {
    static {
        System.out.println("Child  init");
    }
    Child(){
        System.out.println("Construct Child init");
    }
}

public class InitMainExtends {

    public static void main(String[] args) {
        new Child();// new关键字初始化 注释开启和未开启作比较
        System.out.println("======");
        // 通过子类调用从父类继承过来的静态属性，不会引起子类初始化
        System.out.println(Child.v); // 此时Child已经被加载，但未被初始化
    }
}
