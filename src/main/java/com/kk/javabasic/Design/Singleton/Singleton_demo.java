package com.kk.javabasic.Design.Singleton;

/**
 * Created by hutwanghui on 2018/8/11.
 * email:zjjhwanhui@163.com
 * qq:472860892
 * 优点：延迟加载（需要的时候才去加载）,适合单线程操作
 * 缺点： 线程不安全，在多线程中很容易出现不同步的情况，如在数据库对象进行的频繁读写操作时。
 */
//懒汉
public class Singleton_demo {
    /* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
    private static Singleton_demo singletondemo = null;

    //私有化构造方法，就可以防止被实例化
    private Singleton_demo() {

    }

    //通过静态方法创建对象
    public static Singleton_demo getInstance() {
        if (singletondemo == null) {
            singletondemo = new Singleton_demo();
        }
        return singletondemo;
    }

    public static void main(String[] args) {
        Singleton_demo singletondemo = Singleton_demo.getInstance();
        Singleton_demo singletondemo1 = Singleton_demo.getInstance();

        //结果是True
        System.out.println(singletondemo == singletondemo1);
    }
}

//饿汉
class Singleton_ehan {
    private static Singleton_ehan ehan = new Singleton_ehan();

    //禁止他人创建实例
    private Singleton_ehan() {

    }

    public static Singleton_ehan getInstance() {
        return ehan;
    }

    public static void main(String[] args) {
        Singleton_ehan ehan = Singleton_ehan.getInstance();
        Singleton_ehan ehan1 = Singleton_ehan.getInstance();
        System.out.println(ehan == ehan1);
    }
}

//静态内部类
class Singleton_inner {
    private static class inner {
        private static final Singleton_inner SINGLETON_INNER = new Singleton_inner();
    }

    private Singleton_inner() {

    }

    public static final Singleton_inner getInstance() {
        return inner.SINGLETON_INNER;
    }

    public static void main(String[] args) {
        Singleton_inner singleton_inner = Singleton_inner.getInstance();
        Singleton_inner singleton_inner1 = Singleton_inner.getInstance();
        System.out.println(singleton_inner == singleton_inner1);
    }
}

class Singleton_resource {

    public static void main(String[] args) {
        Singleton_resource resource = Singleton_enum.INSTACE.getInstance();
        Singleton_resource resource1 = Singleton_enum.INSTACE.getInstance();
        System.out.println(resource==resource1);
    }
}

enum Singleton_enum {

    INSTACE;
    private Singleton_resource resource;

    Singleton_enum() {
        resource = new Singleton_resource();
    }

    public Singleton_resource getInstance() {
        return resource;
    }
}