package com.kk.javabasic.Nio.buffer;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by hutwanghui on 2018/8/3.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Path_demo {
    public static void main(String[] args) {
        /**
         *  Paths.get()工厂方法，就可以生成绝对路径Path
         */
        //因为是在windows下，所以需要\转义
        Path path = Paths.get("F:\\home\\text1.txt");
        //Path path = Paths.get("/home/jakobjenkov/myfile.txt");

        /**
         * 创建相对路径
         */
        Path currentPath = Paths.get(".");
        //获取绝对路径
        System.out.println(currentPath.toAbsolutePath());
        //路径的标准化，去掉.和..指向真正的路径
        System.out.println(currentPath.normalize().toAbsolutePath());
        System.out.println(currentPath.getFileName());
        System.out.println(currentPath.getNameCount());
        System.out.println(currentPath.toFile());
        /**
         * 创建父路径
         */
        Path parentPath = Paths.get("..");
        System.out.println(parentPath.toAbsolutePath());
    }
}
