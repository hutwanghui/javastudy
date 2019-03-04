package com.kk.javabasic.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ImageUtil;

import java.awt.*;

/**
 * Created by hutwanghui on 2018/10/25.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class HutoolImageUtil {

    public static void main(String[] args) {

        ImageUtil.binary(FileUtil.file("F:\\tmp\\test.png"), FileUtil.file("F:\\tmp\\test1.png"));
    }
}
