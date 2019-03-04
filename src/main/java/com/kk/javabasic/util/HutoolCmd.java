package com.kk.javabasic.util;

import cn.hutool.core.util.RuntimeUtil;

/**
 * Created by hutwanghui on 2018/10/25.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class HutoolCmd {
    public static void main(String[] args) {
        String str = RuntimeUtil.execForStr("ipconfig");
        System.out.println(str);
    }
}
