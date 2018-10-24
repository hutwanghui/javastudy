package com.kk.javabasic.Java9.Collection;

import java.util.Map;
import java.util.Map.Entry;

import static java.util.Map.entry;

/**
 * Created by hutwanghui on 2018/9/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = Map.ofEntries(entry("name", "wanghui")
                , entry("age", "21"));
        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
