package com.kk.algorithm.sort;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 不稳定排序！！！！
 * 思路：先从一个序列中找到一个基准元素，将序列分为两部分，
 * 两端开始“探测”。先从右往左找一个小于基准的数，再从左往右找一个大于基准的数，然后交换他们
 * 直到两端碰头为止（记住位置为i）
 * 碰头了将碰头位置和基准位置交换，这样一来所有比基准值小的都在左边，所有比基准值大的都在右边
 * 通过递归，分别递归左边（left,i-1）和右边(i+1,right)的序列。
 * 快速排序是不稳定的，取决于划分值的选取，
 * 时间复杂度最差情况每次的划分值都是最小\最大和冒泡一样O(n^2)，最好情况，每一次的划分值都是中间数和二分一样O(logN) 平均是O(N*logN)
 * 空间复杂度最差情况是O(n)，最好的是O(logn)。递归的好处就是降低空间复杂度，因为中间划分值可以复用
 */
public class Quick_sort {

    public static void quickCore(int[] ints, int first, int last) {
        //1,找到递归算法的出口
        if (first > last) {
            return;
        }
        int i = first;
        int j = last;
        //这里可以优化，因为划分值决定了算法的时间复杂度,即随机快速排序
        int first_pivot = ints[first];
        while (i != j) {
            //必须让J哨兵先动，每次都让j开始移动保证了最后相遇的位置一定是比基准要小的
            //这样和基准再交换的话就符合一边比基准大，一边比基准小的要求了
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
        int[] ints = {6, 1, 2, 7, 9, 7, 4, 5, 10, 8};
        quickCore(ints, 0, ints.length - 1);
        for (int i : ints) {
            System.out.print(i + "  ");
        }
    }
}
