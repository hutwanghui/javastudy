package com.kk.javabasic.Map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hutwanghui on 2018/7/29.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ConcurrentHashMap_demo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
        //compute :计算，Absent：不存在，Present：存在
        chm.putIfAbsent("姓名", "wanghui");
        String name = chm.putIfAbsent("姓名", "王回");
        System.out.println(name);
        //computeIfAbsent的作用是，如果有key，则按照lambda将value改变，如果没有，就按照lambda的value存
        chm.computeIfAbsent("name", key -> key.concat("lalala"));
        String computedName = chm.get("name");
        System.out.println(computedName);
        chm.computeIfAbsent("age", key -> key.concat("123"));
        String age = chm.get("age");
        System.out.println(age);

        //如果存在则根据旧的key和value计算新的值newValue,
        // 如果newValue不为null，则设置key新的值为newValue, 如果newValue为null, 则删除该key的值
        //map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))
        chm.computeIfPresent("age", (key, value) ->
                value.concat("123333")
        );
        String age_change = chm.get("age");
        System.out.println(age_change);


    }
}
