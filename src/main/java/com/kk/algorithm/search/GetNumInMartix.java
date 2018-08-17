package com.kk.algorithm.search;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 题目：已知一个矩阵从左到右递增，从上到下递增，问求一个数是否在矩阵中
 * 要求：时间复杂度是O(N+M)，空间复杂度是O(1)
 * 思路：从右上角的数比较，
 * 如果比当前数小，左移
 * 如果比当前数大。下移
 * 直到越界
 */
public class GetNumInMartix {
    public static int find(int[][] arr, int num) {
        int beginRow = 0;
        int beginCol = arr.length - 1;
        while (beginCol >= 0 && beginRow <= arr.length - 1) {
            if (num > arr[beginRow][beginCol]) {
                beginCol--;
            } else if (num < arr[beginRow][beginCol]) {
                beginRow++;
            } else {
                return arr[beginRow][beginCol];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 3, 4, 5}, {6, 8, 9, 10}, {11, 13, 16, 17}};
        int result = find(ints, 4);
        if (result != -1) {
            System.out.println("找到了" + result);
        } else {
            System.out.println("没找到");
        }
    }
}
