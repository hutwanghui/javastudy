package com.kk.algorithm.BigData;

import java.util.Random;

/**
 * Created by hutwanghui on 2018/8/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class BigDataSort_bitmap {
    private static final int TOTALNUM = 1000;
    //定义一个byte数组用于缓存所有数据（bitmap）1<<29表2的n次方
    //因为8bit=1byte。2^32/8=2^29
    //bit[]数组显然在计算机中是不存在的，所我们需要将其转化为 java 中的一个基本数据类型存储。显然，byte[] 是最好的选择。
    private byte[] bitmap = new byte[1 << 29];

    public static void main(String[] args) {
        BigDataSort_bitmap ms = new BigDataSort_bitmap();

        byte[] bytes = null;

        Random random = new Random();
        for (int i = 0; i < TOTALNUM; i++) {
            int num = random.nextInt();
            System.out.println("读取了第 " + (i + 1) + "\t个数: " + num);
            bytes = ms.splitBigData(num);
        }
        System.out.println("");
        ms.output(bytes);
    }


    /**
     * 读取数据，并将对应数数据的 到对应的bit中，并返回byte数组
     * java中 int 范围为 -2^31  到  2^31-1. 那么所有可能的数值组成的长度为2^32.
     * 对应的 bit 长度也为 2^32.  那么可以用这样处理之后只需要开辟2^32 bit  = 2^29 byte = 512M 大小的 内存空间 。
     *
     * @param num 读取的数据
     * @return byte数组  dataBytes
     */
    private byte[] splitBigData(int num) {

        //最小值(-2^31)与数组(2^31-1)的最大(2^32)最小索引(0)相对应。从上图可以看出来 int 数值与bit索引相差 2^31次方
        long bitIndex = num + (1l << 31);         //获取num数据对应bit数组（虚拟）的索引
        int index = (int) (bitIndex / 8);         //bit数组（虚拟）在byte数组中的索引
        int innerIndex = (int) (bitIndex % 8);    //bitIndex 在byte[]数组索引index 中的具体位置

        System.out.println("byte[" + index + "] 中的索引：" + innerIndex);


        bitmap[index] = (byte) (bitmap[index] | (1 << innerIndex));
        return bitmap;
    }

    /**
     * 输出数组中的数据
     *
     * @param bytes byte数组
     */
    private void output(byte[] bytes) {
        int count = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(((bytes[i]) & (1 << j)) == 0)) {
                    count++;
                    int number = (int) ((((long) i * 8 + j) - (1l << 31)));
                    System.out.println("取出的第  " + count + "\t个数: " + number);
                }
            }
        }
    }
}
