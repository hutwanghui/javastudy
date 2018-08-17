package com.kk.javabasic.Design.Factory;

/**
 * Created by hutwanghui on 2018/8/8.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public abstract class Operation {
    public abstract float getResult(float firstNum, float lastNum);
}

class AddOperation extends Operation {
    @Override
    public float getResult(float firstNum, float lastNum) {
        return firstNum + lastNum;
    }
}

class SubOperstion extends Operation {

    @Override
    public float getResult(float firstNum, float lastNum) {
        return firstNum - lastNum;
    }
}

class MulOperation extends Operation {

    @Override
    public float getResult(float firstNum, float lastNum) {
        return firstNum * lastNum;
    }
}

class DivOperation extends Operation {

    @Override
    public float getResult(float firstNum, float lastNum) {
        return firstNum / lastNum;
    }
}



