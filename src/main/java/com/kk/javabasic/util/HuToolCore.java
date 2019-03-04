package com.kk.javabasic.util;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.Cloneable;
import cn.hutool.core.util.ObjectUtil;

import java.io.Serializable;

/**
 * Created by hutwanghui on 2018/10/24.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class HuToolCore {

    public static void main(String[] args) {
        Cat cat = new Cat();
        //浅拷贝
        Cat cat1 = cat.clone();
        System.out.println(cat + ":" + cat1);
        cat1.name = "yyyyy";
        System.out.println(cat.name + ":" + cat1.name);
        Cat cat2 = ObjectUtil.cloneIfPossible(cat);
        System.out.println(cat + ":" + cat2);
        cat2.name = "yyyyy";
        System.out.println(cat.name + ":" + cat2.name);
        System.out.println(ObjectUtil.getTypeArgument(cat));
    }

    //支持泛型的克隆类
    private static class Cat implements Cloneable<Cat>, Serializable {
        private String name = "xxxx";
        private int age = 11;

        @Override
        public Cat clone() {
            try {
                return (Cat) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                throw new CloneRuntimeException(e);
            }
        }
    }
}
