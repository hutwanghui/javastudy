package com.kk.javabasic.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hutwanghui on 2018/8/7.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 *  * 演示堆内存溢出
 * 通过run configurations配置下列参数
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 参数-XX：+HeapDumpOnOutOfMemoryError可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后进行分析,文件在项目中
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            System.out.println("===");
            list.add(new OOMObject());
        }
    }
}
