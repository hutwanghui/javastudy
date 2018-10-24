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

    //按顺序打印数组中的元素
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void sortCore_up1(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        for (int i = 0; i < ints.length - 1; i++) {
            boolean exchange = false;  //设置交换变量
            for (int j = 1; j < ints.length - i; j++) {
                if (ints[j - 1] > ints[j]) {
                    int temp = ints[j - 1];
                    ints[j - 1] = ints[j];
                    ints[j] = temp;
                    if (!exchange) exchange = true; //每次只有交换了说明还需要一轮排序
                }
            }
            System.out.print("第" + (i + 1) + "轮排序结果：");
            display(ints);
            if (!exchange) break;  //如果上一轮没有发生交换数据，证明已经是有序的了，结束排序
        }

    }

    public static void sortCore_up2(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        int endpoint = ints.length - 1;
        while (endpoint > 0) {
            int pos = 1;
            for (int j = 1; j < endpoint; j++) {

            }
        }
    }

    public static void sortCore(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        for (int i = ints.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
            System.out.print("第" + (i) + "轮排序结果：");
            display(ints);
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
            display(ints);
        } while (flag > 0);
    }

    //冒泡排序改进3
    public static void bubbleSort_improvement_3(int[] array) {
        int temp;
        int low = 0;
        int high = array.length - 1;
        int counter = 1;
        while (low < high) {
            for (int i = low; i < high; ++i) {   //正向冒泡，确定最大值
                if (array[i] > array[i + 1]) {  //如果前一位大于后一位，交换位置
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            --high;
            for (int j = high; j > low; --j) {   //反向冒泡，确定最小值
                if (array[j] < array[j - 1]) {  //如果前一位大于后一位，交换位置
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            ++low;
            System.out.print("第" + counter + "轮排序结果：");
            display(array);
            counter++;
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 5, 4, 11, 2, 20, 18};
        bubbleSort_improvement_3(ints);
        for (int i : ints) {
            System.out.print(i + "  ");
        }
    }
}
