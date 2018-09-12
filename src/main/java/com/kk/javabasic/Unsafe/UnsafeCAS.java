package com.kk.javabasic.Unsafe;

/**
 * Created by hutwanghui on 2018/8/9.
 * email:zjjhwanhui@163.com
 * qq:472860892
 *//*

import sun.misc.Unsafe;

import java.lang.reflect.Field;


public class UnsafeCAS {
    public static void main(String[] args) {
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
*/