package com.kk.javabasic.Java9.Collection;

import java.util.Set;

/**
 * Created by hutwanghui on 2018/9/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = Set.of("aa", "bb", "dd", "cc");
        set.stream().forEach(s -> System.out.println(s));
    }
}
