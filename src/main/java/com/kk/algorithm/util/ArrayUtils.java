package com.kk.algorithm.util;

import java.util.Random;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ArrayUtils {
    public static int[] generateRandomArray(int size, int value) {
        //Random生成[0,1),*size+1就会生成[0,size+1)的doubule数组，强转后就生成[0,size]的int数组
        int[] arr = new int[(int) (Math.random() * (size + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (value + 1) - (int) Math.random() * (value));
        }
        return arr;
    }

    public static Integer[] generateRandomIntegerArray(int size, int value) {
        //Random生成[0,1),*size+1就会生成[0,size+1)的doubule数组，强转后就生成[0,size]的int数组
        Integer[] arr = new Integer[(int) (Math.random() * (size + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (value + 1) - (int) Math.random() * (value));
        }
        return arr;
    }


    //length用户要求产生字符串的长度
    public static char[] generateCharRandomArray(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(52);
            sb.append(str.charAt(number));
        }
        return sb.toString().toCharArray();
    }

    public static <T> void printArray(T[] objects) {
        for (T o : objects) {
            System.out.print(o + " ");
        }
        System.out.println("\n");
    }

    public static void printIntArray(int[] arr) {
        for (int o : arr) {
            System.out.print(o + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArray(5, 100);
        for (int i : arr) {
            System.out.println(i + " ");
        }
        System.out.println("===========");
        char[] arr1 = generateCharRandomArray(10);
        for (char i : arr1) {
            System.out.println(i + " ");
        }

    }
}
