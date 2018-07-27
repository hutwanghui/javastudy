package com.kk.algorithm.String;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class replaceString {
    public static String replaceSpace(StringBuffer str) {
        int newlength = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newlength = newlength + 3;
            } else {
                newlength++;
            }
        }
        StringBuffer strbuffer = new StringBuffer(newlength);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                strbuffer.append("%");
                strbuffer.append("2");
                strbuffer.append("0");
            } else {
                strbuffer.append(str.charAt(i));
            }
        }
        return strbuffer.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Hello World Wangyi");
        System.out.println(replaceSpace(stringBuffer));
    }
}
