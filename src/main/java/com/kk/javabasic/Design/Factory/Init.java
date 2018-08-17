package com.kk.javabasic.Design.Factory;

import java.io.*;
import java.util.Properties;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Init {
    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        File file = new File("Operation.properties");
        if (file.exists()) {
            System.out.println("加载配置文件");
            properties.load(new FileInputStream(file));
        } else {
            properties.setProperty("+", "com.kk.javabasic.Design.Factory.AddOperationInter");
           // properties.setProperty("-", "com.kk.javabasic.Design.Factory.SubOperationInter");
            properties.store(new FileOutputStream(file), "FRUIT CLASS");
        }
        return properties;
    }
}
