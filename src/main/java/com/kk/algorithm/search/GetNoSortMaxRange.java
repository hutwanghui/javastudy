package com.kk.algorithm.search;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import com.kk.algorithm.util.ArrayUtils;

/**
 * 寻找任意无序数组中，不使用排序寻找出排序后相邻差值最大的元素差值。
 * 思路：
 * 利用桶的概念，收集满足条件区间的数组元素最大值和最小值分桶存放，使得最大差值只来自于跨桶区间而不来自于桶内部。
 */
public class GetNoSortMaxRange {
    public static int getMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        if (max == min) {
            return 0;
        }
        //三个数组表示每一个桶的信息，boolean表示是否为空桶，max和min表示桶中最大和最小
        boolean[] isNotEmpty = new boolean[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        int[] maxs = new int[arr.length + 1];
        for (int j = 0; j < arr.length; j++) {
            //计算当前数据进那一号桶
            int bucketArrayNum = (arr[j] - min) * arr.length / (max - min);
            mins[bucketArrayNum] = isNotEmpty[bucketArrayNum] ? Math.min(mins[bucketArrayNum], arr[j]) : arr[j];
            maxs[bucketArrayNum] = isNotEmpty[bucketArrayNum] ? Math.max(maxs[bucketArrayNum], arr[j]) : arr[j];
            isNotEmpty[bucketArrayNum] = true;
        }

        //遍历每一个非空桶，计算后一个非空桶的最大值减去前一个非空桶的最小值
        //因为最大值和最小值可以确定，所以第一个桶和第二个桶一定是非空的
//        int result = 0;
//        int lastMax = maxs[0]; //表示上一个桶的最大值
//        int i = 1;
//        for (; i <= arr.length; i++) {
//            if (isNotEmpty[i]) {
//                result = Math.max(result, mins[i] - lastMax);
//                lastMax = maxs[i];
//            }
//        }

        int result = 0;
        int lastMin = mins[0]; //表示上一个桶的最大值
        int i = 1;
        for (; i <= arr.length; i++) {
            if (isNotEmpty[i]) {
                result = Math.max(result, maxs[i] - lastMin);
                lastMin = mins[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(10, 100);
        ArrayUtils.printIntArray(arr);
        int max = getMax(arr);
        System.out.println(max);
    }
}
