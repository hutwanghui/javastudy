package com.kk.algorithm.DynamicProgramming;

/**
 * Created by hutwanghui on 2018/8/26.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 斐波那契数列的变体
 * 爬楼梯问题，每次只能爬一阶和两阶，总共有n阶台阶
 * 思路：当走到最后一步的时候，只有两种选择，要么距离N还有1阶，要么还有2阶
 * 因此整个问题可以分解为f(n-1)和f(n-2）的问题，同理f(n-1)也可以分解为小问题
 */
public class ClimbStairs {
    public static int f(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return f(n - 1) + f(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(f(10));
    }
}
