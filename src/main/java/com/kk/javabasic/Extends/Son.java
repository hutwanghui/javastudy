package com.kk.javabasic.Extends;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by hutwanghui on 2018/9/24.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Son extends Father {
    public static void main(String[] args) {
        try {
            Class sonclass = Class.forName("com.kk.javabasic.Extends.Son");
            Method[] methods = sonclass.getMethods();
            Field[] fields = sonclass.getFields();
            for (Method m : methods) {
                m.setAccessible(true);
                System.out.println("权限" + Modifier.toString(m.getModifiers()) + "方法名：" + m.getName());
            }
            for (Field f : fields) {
                f.setAccessible(true);
                System.out.println("权限" + Modifier.toString(f.getModifiers()) + "属性名：" + f.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
