package com.kk.algorithm.String;

/**
 * Created by hutwanghui on 2018/7/26.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 字符串循环左右算法，类似完美洗牌的算法，时间复杂度O(N)，空间复杂度O(1)
 * 输入：abcdefg 3
 * 输出：defgabc
 */
public class ReverString {

    public static void reverString(char[] chars, int from, int to) {
        while (from < to) {
            char temp = chars[from];
            chars[from++] = chars[to];
            chars[to--] = temp;
        }
    }


    public static void main(String[] args) {
        String str = "hello world";
        char[] chars = str.toCharArray();
//        reverString(chars, 0, 2);
//        reverString(chars, 3, chars.length - 1);
        reverString(chars, 0, chars.length - 1);
        System.out.println(        String.valueOf(chars));

        //结果：defgabc
    }
}
