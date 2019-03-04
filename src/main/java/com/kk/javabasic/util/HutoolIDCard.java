package com.kk.javabasic.util;

import cn.hutool.core.util.IdcardUtil;

import java.sql.SQLOutput;

/**
 * Created by hutwanghui on 2018/10/25.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class HutoolIDCard {
    public static void main(String[] args) {
        String ID_18 = "330825199701215919";

        boolean vaildate = IdcardUtil.isvalidCard18(ID_18);

        System.out.println("验证我的身份证是否合法：" + vaildate);
    }
}
