package com.kk.javabasic.Unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by hutwanghui on 2018/8/9.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * Unsafe对象不能直接通过new Unsafe()或调用Unsafe.getUnsafe()获取，原因如下：
 * <p>
 * 不能直接new Unsafe()，原因是Unsafe被设计成单例模式，构造方法是私有的；
 * 不能通过调用Unsafe.getUnsafe()获取，因为getUnsafe被设计成只能从引导类加载器(bootstrap class loader)加载
 *
 * @CallerSensitive public static Unsafe getUnsafe() {
 * Class var0 = Reflection.getCallerClass();
 * if (!VM.isSystemDomainLoader(var0.getClassLoader())) {
 * throw new SecurityException("Unsafe");
 * } else {
 * return theUnsafe;
 * }
 * }
 */
public class UnsafeNewObject {

    class User {
        private Integer id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Unsafe unsafe = getUnsafeMethod();
        try {
            //allocateInstance(Class<?> var1)不调用构造方法生成对象
            User user = (User) unsafe.allocateInstance(User.class);
            //操作对象的成员属性
            unsafe.putObject(user,
                    unsafe.objectFieldOffset(user.getClass().getDeclaredField("name")),
                    "wanghui");

            unsafe.putObject(user,
                    unsafe.objectFieldOffset(user.getClass().getDeclaredField("id")),
                    1);

            System.out.println(user.toString());


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static Unsafe getUnsafeMethod() {
        Unsafe UNSAFE = null;
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
        } catch (Exception e) {
        }
        return UNSAFE;
    }
}
