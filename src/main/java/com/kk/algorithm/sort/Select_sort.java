package com.kk.algorithm.sort;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 时间复杂度分析和结果同冒泡排序
 * 选择排序思路：
 * 将序列中未排序的部分中的最小元素，放入到序列的已排序部分的首位；
 * 接着在未排序部分继续寻找最小元素，放入已排序部分的末尾，直到所有元素排序完毕。
 */
public class Select_sort {

    public static void selectCore(int[] ints) {
        int tmp;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    tmp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 55, 2, 53, 23, 65, 12, 76, 32, 66};
        selectCore(ints);
        for (int i : ints) {
            System.out.print(i + "  ");
        }
    }
}
