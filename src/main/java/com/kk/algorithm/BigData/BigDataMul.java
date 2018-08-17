package com.kk.algorithm.BigData;

/**
 * Created by hutwanghui on 2018/8/14.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class BigDataMul {
    /**
     * 大数相乘方法二O(n^2)
     */
    public static int[] bigNumberMultiply2(int[] num1, int[] num2) {
        // 分配一个空间，用来存储运算的结果，num1长的数 * num2长的数，结果不会超过num1+num2长
        int[] result = new int[num1.length + num2.length];

        // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                result[i + j + 1] += num1[i] * num2[j];  // (因为进位的问题，最终放置到第i+j+1位)
            }
        }

        //单独处理进位
        for (int k = result.length - 1; k > 0; k--) {
            if (result[k] > 10) {
                result[k - 1] += result[k] / 10;
                result[k] %= 10;
            }
        }
        return result;
    }

    /**
     * 大数相乘方法分治Karatsuba
     * 5678 * 1234的过程，首先是拆分成abcd四个部分，a=56,b=78,c=12,d=34
     * 然后分别计算ac, bd, (a+b)*(c+d)
     * 最后再用第三个算式的结果减去前面两个（其实得到的就是bc+ad，但是减少了乘法步骤）
     * 然后，计算式1后面加4个0，计算式2后面不加，计算式3后面加2个0，再把这三者相加，就是正确结果。
     */
    public static long karatsuba(Long num1, Long num2) {

        //递归终止条件
        if (num1 < 10 || num2 < 10) return num1 * num2;

        // 计算拆分长度
        int size1 = String.valueOf(num1).length();
        int size2 = String.valueOf(num2).length();
        int halfN = Math.max(size1, size2) / 2;

    /* 拆分为a, b, c, d */
        long a = Long.valueOf(String.valueOf(num1).substring(0, size1 - halfN));
        long b = Long.valueOf(String.valueOf(num1).substring(size1 - halfN));
        long c = Long.valueOf(String.valueOf(num2).substring(0, size2 - halfN));
        long d = Long.valueOf(String.valueOf(num2).substring(size2 - halfN));

        // 计算z2, z0, z1, 此处的乘法使用递归
        long z2 = karatsuba(a, c);
        long z0 = karatsuba(b, d);
        long z1 = karatsuba((a + b), (c + d)) - z0 - z2;

        return (long) (z2 * Math.pow(10, (2 * halfN)) + z1 * Math.pow(10, halfN) + z0);
    }


    public static void main(String[] args) {
        int num1[] = {9, 8, 5, 4, 3, 2, 1, 3, 4, 5};
        int num2[] = {2, 1};
        int[] result = bigNumberMultiply2(num1, num2);
        for (int i : result) {
            System.out.print(i);
        }
    }
}
