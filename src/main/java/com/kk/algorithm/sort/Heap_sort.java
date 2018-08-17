package com.kk.algorithm.sort;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import com.kk.algorithm.util.ArrayUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 堆的数据结构就是一个完全二叉树，通过数组进行抽象
 * 当前节点：i
 * 左孩子节点：2*i+1
 * 右孩子节点：2*i+2
 * 父节点：(i-1)/2
 * 思路：
 * 1、堆的构建：先根据下标计算其父节点的下标，然后与父节点的值比较，如果比父节点大，与父节点交交换
 * 2、堆的减小，实现排序,即相当于数组分了片，在未排序的范围内，将最大和最小分别放于未排序数组的首尾，然后首尾交互
 */
public class Heap_sort {


    public static void buildDa(int[] arr) {
        // 求出当前堆中最后一个存在孩子结点的索引
        int pos = (arr.length - 1) / 2;
        // 从该结点结点开始，执行建堆操作
        for (int i = pos; i >= 0; i--) {
            adjustDa(arr, i, arr.length);// 在建堆过程中，及时调整堆中索引为i的结点
        }
    }

    public static void buildSm(int[] arr) {
        // 求出当前堆中最后一个存在孩子结点的索引
        int pos = (arr.length - 1) / 2;
        // 从该结点结点开始，执行建堆操作
        for (int i = pos; i >= 0; i--) {
            adjustSm(arr, i, arr.length);// 在建堆过程中，及时调整堆中索引为i的结点
        }
    }

    public static void adjustDa(int[] arr, int index, int HeapSize) {

        int left = index * 2 + 1;

        //如果左子树存在
        while (left < HeapSize) {
            //找到左右子节点较大的那个
            int largest = left + 1 < HeapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            if (arr[largest] > arr[index]) {
                swap(arr, index, largest);
                index = left;
                left = index * 2 + 1;
            } else {
                break;
            }
        }
    }

    public static void adjustSm(int[] arr, int index, int HeapSize) {
        int left = index * 2 + 1;

        while (left < HeapSize) {
            int least = left + 1 < HeapSize && arr[left + 1] < arr[left] ? left + 1 : left;
            if (arr[least] < arr[index]) {
                swap(arr, index, least);
                index = left;
                left = 2 * index + 1;
            } else {
                break;
            }
        }
    }

    public static void heapCoreDa(int[] arr) {
        buildDa(arr);
        for (int i = 0; i < arr.length; i++) {
            swap(arr, 0, arr.length - i - 1);
            adjustDa(arr, 0, arr.length - i - 1);
        }
    }

    public static void heapCoreSm(int[] arr) {
        buildSm(arr);
        for (int i = 0; i < arr.length; i++) {
            swap(arr, 0, arr.length - i - 1);
            adjustSm(arr, 0, arr.length - i - 1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(10, 100);
        ArrayUtils.printIntArray(arr);
        heapCoreDa(arr);
        ArrayUtils.printIntArray(arr);
        int[] arr1 = ArrayUtils.generateRandomArray(10, 100);
        ArrayUtils.printIntArray(arr1);
        heapCoreSm(arr1);
        ArrayUtils.printIntArray(arr1);

        String str = "hello world hello java hello hadoop hello spark hello hadoop";
        String[] strArr = str.split(" ");

        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : strArr) {
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else
                hm.put(s, 1);
        }
        System.out.println(hm.toString());

        System.out.println(hm.toString());

    }
}
