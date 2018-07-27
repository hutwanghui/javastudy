package com.kk.algorithm.String;

/**
 * Created by hutwanghui on 2018/7/26.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 遍历每一个字符之后，得到一个关于半径的数组，数组最大的值减1就是最大回文字串的长度
 */
public class Manacher {

    public static char[] init(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        //为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
        //防止数组溢出
        stringBuilder.append("$");
        stringBuilder.append("#");
        for (char c : chars) {
            stringBuilder.append(c);
            stringBuilder.append("#");
        }
        return stringBuilder.toString().toCharArray();
    }

    // 这个算法是O(n)的，因为max只会随着里层while的迭代而增长，不会减少。
    public static void manacherCore(char[] chars, int[] p, int max, int id) {
        for (int i = 1; i < chars.length; i++) {
            //step1: 满足条件表示:T[i]被包含在T[id]的最大回文长度（mx）内
            int minR = 1;
            if (i < max + id) {
                //2*id-i是关于id的对称点,实际上就是比较mx+id>i的两种情况
                //情况1：j的回文长度向左侧延伸但不超过左侧的mx,i的回文长度大于等于j的回文长度
                //情况2：j的回文长度想做延伸超过了左侧mx,可是i的右侧超过mx的字符还没有被遍历过，因此i的回文长度只能大于等于mx－i
                //因此只需要求这两个情况的最小值，
                //i 点通过对程特性，能够获得一个最基本的回文长度，那就可以在此之上继续循环判断。也就不需要每次都重复计算长度
                minR = Math.min(max - i, p[2 * id - i]);
            } else {
                minR = 1;
            }

            // step2:尝试更大的半径
            while (i - minR >= 0 && i + minR < chars.length && chars[i - minR] == chars[i + minR]) {
                minR++;
            }

            //step3:更新边界和回文中心坐标， //如果回文字串的长度超过了现有的右边界，则确立新的中心和右边界
            if (minR > max) {
                //mx 代表以 id 为中心的最长回文的右边界，也就是mx = id + p[id]。
                max = i + minR;
                id = i;
            }
            p[i] = minR;
        }
    }

    public static void main(String[] args) {
        char[] chars = "abba".toCharArray();
        chars = init(chars);
        //定义存放以i为中心的回文的最大半径的数组
        int[] p = new int[chars.length];
        //定义已知回文中，最右的边界的坐标
        int max = 0;
        //定义已知回文中，拥有最右边界的中点坐标
        int id = 0;
        manacherCore(chars, p, max, id);
        int maxLength = 0;
        for (int length : p) {
            System.out.println("" + length);
            if (length > maxLength) {
                maxLength = length;
            }
        }
        System.out.printf("最长回文" + (maxLength - 1));
    }
}
