package com.kk.algorithm.DynamicProgramming;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 斐波拉契数列
 * Fibonacci (n) = 1;   n = 0
 * Fibonacci (n) = 1;   n = 1
 * Fibonacci (n) = Fibonacci(n-1) + Fibonacci(n-2)
 * 可以使用递归来解决，但是递归树中很多节点被重复执行，算法并不是最优的
 */
public class Fibonacci {

    /**
     * f(6)
     * /  \
     * f(5) f(4)
     * /  \   / \
     * f(4)f(3)f(3)f(2)
     * / \ / \ / \ / \
     * f(3)f(2)..........
     */
    //此暴力递归算的重复计算的次数太多，效率低
    //时间复杂度：O(2^N)
    //空间复杂度：O(N)
    public int digui(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return digui(n - 1) + digui(n - 2);
    }


}
