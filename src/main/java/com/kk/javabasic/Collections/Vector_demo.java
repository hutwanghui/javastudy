package com.kk.javabasic.Collections;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by hutwanghui on 2018/7/29.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Vector_demo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("wanghui");
        vector.add("WangHui");
        System.out.println(vector.toString());
        //如果index大于vector当前的size+1 会报java.lang.ArrayIndexOutOfBoundsException: 4 > 2的错误
        //vector.add(4, "four");
        vector.add(vector.size(), "end");
        //Enumeration的数据类型
        Enumeration<String> enumration = vector.elements();
        while (enumration.hasMoreElements()) {
            System.out.println(enumration.nextElement());
        }
        System.out.println(vector.toString());

    }
}
