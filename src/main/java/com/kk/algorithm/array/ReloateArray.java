package com.kk.algorithm.array;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by hutwanghui on 2018/10/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ReloateArray {

    public static void reverString(char[] chars, int from, int to) {
        while (from < to) {
            char temp = chars[from];
            chars[from++] = chars[to];
            chars[to--] = temp;
        }
    }


    public static int getNum(int n) {
        int time = 0;
        while (n >= 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n - 1) / 2;
                time++;
            }
        }
        return time;

    }


    public static void rotate(int temp[][]) {
        int len = temp.length;
        int b[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                b[j][len - 1 - i] = temp[i][j];
            }
        }
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                temp[i][j] = b[i][j];
    }


    public static String getDate(String releaseDate, int day) {
        LocalDate beginDateTime = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDateTime = beginDateTime.plus(day, ChronoUnit.DAYS);
        return endDateTime.toString();
    }

    public static int buckCore(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int max = 10;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        //准备桶子，但是原数组不能有负数
        int[] help = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            help[arr[i]]++;
        }
        int k = 0;
        for (int j = 0; j < help.length; j++) {
            while (help[j]-- == 0) {
                stringBuilder.append(j);
            }
        }
        return Integer.valueOf(stringBuilder.toString());
    }

    public static int findNum(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                stringBuilder.append(i);
            }
        }
        return Integer.valueOf(stringBuilder.toString());
    }

    /********* Begin *********/
    public static int getLostScores(int[] nums) {
        //请在此补全你的代码

        int value = buckCore(nums);
        return value;

    }

    public static Long va(int num) {
        Integer b = Integer.valueOf(num);
        return b.longValue();
    }

    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println(getLostScores(nums));
    }
}
