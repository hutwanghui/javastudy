package com.kk.javabasic.jvm;

/**
 * Created by hutwanghui on 2018/8/7.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class test {
    public static void main(String[] args) {


        long maxMemory = Runtime.getRuntime().maxMemory();//返回Java虚拟机试图使用的最大内存量。

        Long totalMemory = Runtime.getRuntime().totalMemory();//返回Java虚拟机中的内存总量。

        System.out.println("MAX_MEMORY =" + maxMemory + "(字节)、" + (maxMemory / (double) 1024 / 1024) + "MB");

        System.out.println("TOTAL_ MEMORY = " + totalMemory + "(字节)" + (totalMemory / (double) 1024 / 1024) + "MB");

    }
}
