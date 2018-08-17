/*
package com.kk.algorithm.sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

*/
/**
 * Created by hutwanghui on 2018/8/11.
 * email:zjjhwanhui@163.com
 * qq:472860892
 *//*

public class Heap_Hash_map {

    private String name;
    private int count;

    public static void buildSm(HashMap<String,Integer> hashMap) {
        // 求出当前堆中最后一个存在孩子结点的索引
        int pos = (hashMap.size() - 1) / 2;
        // 从该结点结点开始，执行建堆操作
        for (int i = pos; i >= 0; i--) {
            adjustSm(hashMap, i, hashMap.size());// 在建堆过程中，及时调整堆中索引为i的结点
        }
    }

    public static void adjustSm(HashMap<String,Integer> hashMap, int index, int HeapSize) {
        int left = index * 2 + 1;

        while (left < HeapSize) {
            int least = left + 1 < HeapSize && arr < (int) arr[left] ? left + 1 : left;
            if ((int) arr[least] < (int) arr[index]) {
                swap(arr, index, least);
                index = left;
                left = 2 * index + 1;
            } else {
                break;
            }
        }
    }

    public static void swap(HashMap<String,Integer> hashMap, int i, int j) {
        Map.Entry<String,Integer> tmp = hashMap.get;
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] heapCore(HashMap<String,Integer> hashMap) {

        buildSm(objects);
        for (int i = 0; i < objects.length; i++) {
            swap(objects, 0, objects.length - i - 1);
            adjustSm(objects, 0, objects.length - i - 1);
        }
        int[] result = new int[objects.length];
        for (int j = 0; j < result.length; j++) {
            result[j] = (int) objects[j];
        }
        return result;
    }
}

*/
