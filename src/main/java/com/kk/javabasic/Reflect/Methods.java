package com.kk.javabasic.Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 显示类加载，获取方法签名
 */
public class Methods {
    public static void main(String[] args) throws ClassNotFoundException {
        Class strClass = Class.forName("java.lang.String");
        Method[] methods = strClass.getMethods();
        for (Method m : methods) {
            //获取修饰符标志的字符串
            String mod = Modifier.toString(m.getModifiers());
            System.out.println(mod + " " + m.getName());
            //获取方法的参数类型
            Class<?>[] ps = m.getParameterTypes();
            if (ps.length == 0) {
                System.out.print(')');
            }
            for (int i = 0; i < ps.length; i++) {
                char end = i == ps.length - 1 ? ')' : ',';
                System.out.print(ps[i].getSimpleName() + end);
            }
            System.out.println();
        }
    }
}
