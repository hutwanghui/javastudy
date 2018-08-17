package com.kk.javabasic.Reflect;

import java.lang.reflect.Field;

/**
 * Created by hutwanghui on 2018/8/9.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class FieldsTest {

    public static void main(String[] args) {
        try {
            Fields rt = new Fields("李四", "24");
            fun(rt);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void fun(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        System.out.println("替换之前的:");
        for (Field field : fields) {
            //setAccessible让我们在用反射时访问私有变量,否则会抛can not access a member of class com.kk
            field.setAccessible(true); // 必须设置为true才可以修改成员变量
            System.out.println(field.getName() + "=" + field.get(obj));
            if (field.getType().equals(java.lang.String.class)) {
                String org = (String) field.get(obj);
                field.set(obj, org.replace("李", "b"));
            }

        }
        System.out.println("替换之后的：");
        for (Field field : fields) {
            System.out.println(field.getName() + "=" + field.get(obj));
        }
    }

}
