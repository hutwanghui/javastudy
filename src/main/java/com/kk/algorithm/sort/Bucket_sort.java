package com.kk.algorithm.sort;

import com.kk.algorithm.util.ArrayUtils;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 桶排序
 * 插入排序、堆排序、归并排序等排序方法，在排序的最终结果中，各个元素的次序依赖于他们之间的比较，我们把这一类的排序算法称为比较排序。在最坏情况下，任何比较排序算法都要经过 Omega（nlgn）次比较。因此堆排序和归并排序都是渐近最优的比较排序算法。
 * 计数排序、基数排序和桶排序因为不采用比较排序方法，因此可以打破其下界。本文主要介绍计数排序和桶排序。
 */
public class Bucket_sort {
    public static void buckCore(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        //准备桶子，但是原数组不能有负数
        int[] help = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }
        int k = 0;
        for (int j = 0; j < help.length; j++) {
            while (help[j]-- > 0) {
                arr[k++] = j;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(10, 100);
        ArrayUtils.printIntArray(arr);
        buckCore(arr);
        ArrayUtils.printIntArray(arr);
    }
}
