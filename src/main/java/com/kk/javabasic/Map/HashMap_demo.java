package com.kk.javabasic.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * HashMap
 * 将一个key-value作为一个整体进行处理，系统根据key的Hash值计算key-value的存储位置，这样可以保证快速存
 */
public class HashMap_demo {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("name", "wanghui");
        hm.put("age", "22");
        hm.put(null, null);
        //put操作的过程
        String hash_null = hm.put("gender", "woman");
        System.out.println("put一个没有过的key" + hash_null);
        System.out.println(hm.toString());
        System.out.println("hm的key集合:" + hm.keySet().toString());
        System.out.println("hm的value集合：" + hm.values().toString());
        //迭代key集合元素
        Iterator<String> iterableKey = hm.keySet().iterator();
        while (iterableKey.hasNext()) {
            System.out.println(iterableKey.next());
        }
        Iterator<Map.Entry<String, String>> iteratorKeyAndValue = hm.entrySet().iterator();
        while (iteratorKeyAndValue.hasNext()) {
            Map.Entry entry = iteratorKeyAndValue.next();
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

        //put会直接调用putVal，返回 key的hash值对应的位置之前的value，如果没有，直接返回空
        String hash = hm.put("gender", "man");
        //通过对key的hashCode()进行hashing，并计算下标( n-1 & hash)，从而获得buckets的位置。如果产生碰撞，则利用key.equals()方法去链表中查找对应的节点。
        String name = hm.get("name");
        System.out.println("put一个已经有的key" + hash);
        System.out.println("get一个value" + name);

        //拷贝成一个object对象，也就是新的hashMap对象
        Object o = hm.clone();
        System.out.println(o.toString());

        //1.8新特性,核心是使用concurrentHashMap实现的
        //若不存在，返回指定的默认值
        String value_default = hm.getOrDefault("default", "abc");
        System.out.println(value_default);

        //不存在则添加，返回null，存在则覆盖，返回oldValue
        String put_value = hm.putIfAbsent("sex", "man");
        String put_value_notEmpty = hm.put("gender", "woman");
        System.out.println("测试putIfAbsent：不存在" + put_value + " 存在" + put_value_notEmpty);


    }
}
