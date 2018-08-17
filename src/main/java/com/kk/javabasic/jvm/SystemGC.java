package com.kk.javabasic.jvm;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 打印GC信息 input: -XX:+PrintGC
 */
@SuppressWarnings("unused")
public class SystemGC {

    public void localVarGc1() {
        byte[] bytes = new byte[8 * 1024 * 1024];
        System.gc();
    }

    public void localVarGc2() {
        byte[] bytes = new byte[6 * 1024 * 1024];
        bytes = null;
        System.gc();
    }

    public void localVarGc3() {
        {
            byte[] bytes = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }

    public void localVarGc4() {
        {
            byte[] bytes = new byte[6 * 1024 * 1024];
        }
        int a = 4;
        System.gc();
    }

    public void localVarGc5() {
        localVarGc1();
        System.gc();
    }

    public static void main(String[] args) {
        SystemGC ins = new SystemGC();
        ins.localVarGc1();
//         ins.localVarGc2();
//         ins.localVarGc3();
//         ins.localVarGc4();
//        ins.localVarGc5();
    }
}
