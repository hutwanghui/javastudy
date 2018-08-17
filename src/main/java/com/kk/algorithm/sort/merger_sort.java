package com.kk.algorithm.sort;

import com.kk.algorithm.util.ArrayUtils;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 时间复杂度是O(N*logN)，额外空间复杂度是O(N)
 * 利用递归的思想，大而化小
 */
public class merger_sort {

    public static void mergerCore(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) / 2);
        mergerCore(arr, left, mid);
        mergerCore(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        //因为排序会被递归调用，所以数组的长度需要动态确定。
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        //在两个数组不越界的情况下，将小的放入help数组，并将p向后移
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        //下面两种情况只会有一种越界的情况出现p1<=mid说明p2越界了，那么就将左边的数组（是排好序的）放入help数组
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(10, 100);
        ArrayUtils.printIntArray(arr);
        mergerCore(arr, 0, arr.length - 1);
        ArrayUtils.printIntArray(arr);
    }
}
