package com.kk.javabasic;

import java.util.*;

/**
 * Created by msi- on 2018/6/21.
 */

public class test {
    public static void main(String[] args) {


        Map<String, Long> map = new HashMap<String, Long>();
        map.put("c", 33333L);
        map.put("a", 11111L);
        map.put("d", 44444L);
        map.put("e", 55555L);
        map.put("b", 22222L);

        //将map.entrySet()转换成list
        List<Map.Entry<String, Long>> list = new ArrayList<Map.Entry<String, Long>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            //降序排序
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                //return o1.getValue().compareTo(o2.getValue());
                List<String> list1=new ArrayList<>();

                return o2.getValue().compareTo(o1.getValue());

            }
        });

        for (Map.Entry<String, Long> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }


    }
}
