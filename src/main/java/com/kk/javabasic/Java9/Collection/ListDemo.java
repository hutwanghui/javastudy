package com.kk.javabasic.Java9.Collection;

import java.util.List;

/**
 * Created by hutwanghui on 2018/9/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "orange");
        try {
            list.add("lemon");
        } catch (UnsupportedOperationException e) {
            System.err.println("unable to modify list");
        }
        list.stream().map(s -> s + "111").forEach(s -> System.out.println(s));
    }
}
