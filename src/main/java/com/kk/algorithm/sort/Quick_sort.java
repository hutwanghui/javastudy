package com.kk.algorithm.sort;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 思路：先从一个序列中找到一个基准元素，将序列分为两部分，
 * 两端开始“探测”。先从右往左找一个小于基准的数，再从左往右找一个大于基准的数，然后交换他们
 * 直到两端碰头为止（记住位置为i）
 * 碰头了将碰头位置和基准位置交换，这样一来所有比基准值小的都在左边，所有比基准值大的都在右边
 * 通过递归，分别递归左边（left,i-1）和右边(i+1,right)的序列。
 */
public class Quick_sort {

    public static void quickCore(int[] ints, int first, int last) {
        //1,找到递归算法的出口
        if (first > last) {
            return;
        }
        int i = first;
        int j = last;
        int first_pivot = ints[first];
        while (i != j) {
            //从右往左找比基准小的数，因为小的会跳出循环
            while (ints[j] >= first_pivot && i < j) {
                j--;
            }
            //从左往右找比基准大的数，因为大的会跳出循环
            while (ints[i] <= first_pivot && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = ints[i];
                ints[i] = ints[j];
                ints[j] = tmp;
            }
        }
        //最终将基准数归位
        ints[first] = ints[i];
        ints[i] = first_pivot;
        if (i != 0) {
            //为了防止第一个选中的基准值过于小而导致递归运算的数组越界
            quickCore(ints, first, i - 1);//继续处理左边的，这里是一个递归的过程
        }

        quickCore(ints, i + 1, last);//继续处理右边的 ，这里是一个递归的过程

    }

    public static void main(String[] args) {
        int[] ints = {1, 55, 2, 53, 23, 65, 12, 76, 32, 66};
        quickCore(ints, 0, ints.length - 1);
        for (int i : ints) {
            System.out.print(i + "  ");
        }
    }
}
