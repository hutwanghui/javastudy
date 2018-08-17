package com.kk.javabasic.Design.Factory;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        float firstNum = in.nextFloat();
        System.out.println("请输入第二个数字：");
        float secondNum = in.nextFloat();
        System.out.println("请输入运算符号：");
        String countQuato = in.next();
        System.out.println(count(firstNum, secondNum, countQuato));

        Properties properties = Init.getProperties();
        System.out.println(count_reflact(firstNum, secondNum, properties.getProperty(countQuato)));
    }

    private static float count(float firstNum, float secondNum, String countQuato) {
        //使用静态工厂创建类的实例
        Operation operation = OperationFactory.generationOperation(countQuato);
        return operation.getResult(firstNum, secondNum);
    }

    private static float count_reflact(float firstNum, float secondNum, String countQuato) {
        //使用静态工厂创建类的实例
        OperationInter operation = OperationFactory.generationOperation_Reflact(countQuato);
        return operation.getResult(firstNum, secondNum);
    }
}
