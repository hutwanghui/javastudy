package com.kk.algorithm.String;

/**
 * Created by hutwanghui on 2018/7/26.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
/*
因为str字符串的总长度是n，并且match字符串的总长度是m，所以时间复杂度是o(n)
思路：利用已经部分匹配这个有效信息，保持i指针不回溯，通过修改j指针，让模式串尽量地移动到有效的位置。
重点就在于当某一个字符与主串不匹配时，我们应该知道j指针要移动到哪，
最前面的k个字符和j之前的最后k个字符是一样的。公式：p[0~k-1]==T[j-k~j-1]

next[i]表示，在match字符串当前位置前面的字符串的最长前缀（不包含最后一个字符）=最长后缀（不包含第一个字符）的长度。

 */
public class KMP {
    public static int[] getNextArray(char[] match) {
        if (match.length == 1) {
            return new int[]{-1};
        } else {
            int[] next = new int[match.length];
            next[0] = -1;
            next[1] = 0;
            //pos表示当前位置
            int pos = 2;
            //cn每次跳的情况
            int cn = 0;
            //因为Pos=(0.m),pos-cn=(0,m)
            //循环总体的次数不会大于match.length,所以这个方法的时间复杂度为o(m)
            while (pos < next.length) {
                //如果比较的字符相同，则next[i]=next[i]+1,否则向前跳直到匹配next[i]=next[cn]+1
                if (match[pos - 1] == match[cn]) {
                    next[pos++] = ++cn;
                } else if (cn > 0) {
                    //向前跳的过程,表示前一个字符的最长前缀后缀匹配长度
                    cn = next[cn];
                } else {
                    next[pos++] = 0;
                }
            }
            return next;
        }
    }


    public static int match(char[] str, char[] match, int[] next) {
        //初始化主串和匹配串的位置
        int i = 0;
        int j = 0;
        while (i < str.length && j < match.length) {
            //需要移动i的情况
            if (j == -1 || str[i] == match[j]) {
                i++;
                j++;
            } else {
                //j回到指定位置
                j = next[j];
            }
        }
        if (j == match.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        char[] str = new char[]{'a', 'b', 'd', 'a', 'b', 'c', 'a', 'b', 'c', 'd', 'a', 'c', 'c', 'e'};
        char[] match = new char[]{'a', 'b', 'c', 'a', 'b', 'c', 'd'};
        int[] next = getNextArray(match);
        int result = match(str, match, next);
        System.out.println(result);
    }
}
