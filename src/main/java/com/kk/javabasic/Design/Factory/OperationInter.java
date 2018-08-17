package com.kk.javabasic.Design.Factory;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 使用反射机制实现的工厂模式可以通过反射取得接口的实例，
 * 但是需要传入完整的包和类名。而且用户也无法知道一个接口有多少个可以使用的子类，
 * 所以我们通过属性文件的形式配置所需要的子类。
 */
public interface OperationInter {

    public abstract float getResult(float firstNum, float lastNum);
}

class AddOperationInter implements OperationInter {

    @Override
    public float getResult(float firstNum, float lastNum) {
        return firstNum + lastNum;
    }
}

class SubOperationInter implements OperationInter {

    @Override
    public float getResult(float firstNum, float lastNum) {
        return firstNum - lastNum;
    }
}

class MulOperationInter implements OperationInter {

    @Override
    public float getResult(float firstNum, float lastNum) {
        return firstNum * lastNum;
    }
}

class DivOperationInter implements OperationInter {

    @Override
    public float getResult(float firstNum, float lastNum) {
        return firstNum / lastNum;
    }
}
