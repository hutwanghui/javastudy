package com.kk.javabasic.Design.Chain;

/**
 * Created by hutwanghui on 2018/8/19.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public abstract class Handler {

    //用于判断链后续有无责任负责人
    private Handler successor;

    protected void executor() {
        handlerProcessor();
        if (successor != null) {
            //链式调用
            successor.executor();
        }
    }

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handlerProcessor();
}
