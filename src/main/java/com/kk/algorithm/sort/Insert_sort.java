package com.kk.algorithm.sort;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 时间复杂度。最好O(N)比如已经排好序的,最坏O(N^2)
 * 空间复杂度，O(1)
 * 思路类似扑克牌抽牌插入
 */
public class Insert_sort {

    public static void insertCore(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        for (int i = 1; i < ints.length; i++) {
            //i-1前的都是排好序了的
            int j = i;
            while (j > 0) {
                if (ints[j - 1] < ints[i]) {
                    ints[j] = ints[j - 1];
                    j--;
                }

            }
            ints[j] = ints[i];
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 55, 2, 53, 23, 65, 12, 76, 32, 66};
        insertCore(ints);
        for (int i : ints) {
            System.out.print(i + "  ");
        }
    }
}
