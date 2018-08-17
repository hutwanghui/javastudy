package com.kk.javabasic.Design.Factory;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 简单工厂模式：无需知道类的具体实现细节，可以根据参数的不同动态创建返回不同类的实例
 * 静态工厂模式：Factory类为静态类或包含静态方法
 * 　Product：抽象产品类，将具体产品类公共的代码进行抽象和提取后封装在一个抽象产品类中。
 * <p>
 * 　　ConcreteProduct：具体产品类，将需要创建的各种不同产品对象的相关代码封装到具体产品类中。
 * 以上两类就是Operation.java
 * <p>
 * 　　Factory：工厂类，提供一个工厂类用于创建各种产品，在工厂类中提供一个创建产品的工厂方法，
 * 该方法可以根据所传入参数的不同创建不同的具体产品对象。
 * <p>
 * OperationFactory
 * <p>
 * 　　Client：客户端类，只需调用工厂类的工厂方法并传入相应的参数即可得到一个产品对象。
 */
public class OperationFactory {
    public static Operation generationOperation(String OperationFlag) {
        Operation o = null;
        switch (OperationFlag) {
            case "+":
                o = new AddOperation();
                break;
            case "-":
                o = new SubOperstion();
                break;
            case "*":
                o = new MulOperation();
                break;
            case "/":
                o = new DivOperation();
                break;
            default:
                break;
        }
        return o;
    }

    public static OperationInter generationOperation_Reflact(String className) {
        OperationInter o = null;
        try {
            o = (OperationInter) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }


}
