package com.kk.javabasic.Thread.sync.ObjectNotThisLock;

/**
 * Created by msi- on 2018/6/23.
 * 使用非This作为锁对象的优点：如果一个类中有多个synchronized方法，多个同步方法之间不会阻塞
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA thread = new MyThreadA(myService);
        thread.setName("线程1");
        MyThreadB threadB = new MyThreadB(myService);
        threadB.setName("线程2");
        thread.start();
        threadB.start();
    }
}
