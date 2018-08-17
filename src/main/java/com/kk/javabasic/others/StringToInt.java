package com.kk.javabasic.others;

/**
 * Created by hutwanghui on 2018/8/13.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class StringToInt {
    public static void main(String[] args) {
        String str = "12345";
        System.out.println(StringToInt(str));
    }

    public static int StringToInt(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            System.out.println((chars[i] - '0') * Math.pow(10, chars.length - 1 - i));
            result += (int) (chars[i] - '0') * Math.pow(10, chars.length - 1 - i);
        }
        return result;
    }
}
