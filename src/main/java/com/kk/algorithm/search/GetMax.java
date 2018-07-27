package com.kk.algorithm.search;

import com.kk.algorithm.util.ArrayUtils;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class GetMax {
    public static int getMax(Integer[] arr, int left, int right) {
        //递归出口，base case
        if (left == right) {
            return arr[left];
        }
        int mid = left + ((right - left) / 2);
        int leftMax = getMax(arr, left, mid);
        int rightMax = getMax(arr, mid+1, right);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        Integer[] arr = ArrayUtils.generateRandomIntegerArray(10, 100);
        ArrayUtils.<Integer>printArray(arr);
        int max = getMax(arr, 0, arr.length - 1);
        System.out.println(max);
    }
}
