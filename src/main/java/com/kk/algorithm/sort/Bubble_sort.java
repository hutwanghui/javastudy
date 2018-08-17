package com.kk.algorithm.sort;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 时间复杂度分析：O(n^2),空间复杂度为O(1)即不需要额外空间
 * 冒泡排序优化版本：
 * 1、相邻比较，两两交换
 * 2、记住有改变的下标，下一次只需要在0-->flag之间排序即可
 * 3、总迭代次数=（N-1）+（N-2）+ ... + 1 + 0 = N *（N-1）/ 2（推导）。总时间= c * N *（N-1）/ 2 = O（N ^ 2）。
 */
public class Bubble_sort {
    public static int flag = 0;

    public static void sortCore(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        for (int i = ints.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (ints[j] < ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
    }

    public static void sortCore_simple(int[] ints) {
        flag = ints.length;
        do {
            int j = flag;
            flag = 0;
            for (int i = 1; i < j; i++) {
                if (ints[i] < ints[i - 1]) {
                    int temp = ints[i];
                    ints[i] = ints[i - 1];
                    ints[i - 1] = temp;
                    flag = i;
                }
            }
        } while (flag > 0);
    }

    public static void main(String[] args) {
        int[] ints = {1, 55, 2, 53, 23, 65, 12, 76, 32, 66};
        sortCore(ints);
        for (int i : ints) {
            System.out.print(i + "  ");
        }
    }
}
