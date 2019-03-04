package com.kk.javabasic.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;

/**
 * Created by hutwanghui on 2018/10/25.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class HuToolFile {

    public static void main(String[] args) {
        File file = FileUtil.file("F:\\tmp\\test.json");
        System.out.println(FileUtil.size(file));
        System.out.println(FileUtil.appendUtf8Lines(CollUtil.toList("test", "test2"), file));
        System.out.println(FileUtil.size(file));
    }
}
