package com.kk.javabasic.Design.Chain;

import java.util.List;

/**
 * Created by hutwanghui on 2018/8/19.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Chain {
    private List<Chain_handler> handlerChain;

    private int index = 0;

    public void procceed() {
        if (index >= handlerChain.size()) {
            return;
        }
        //procceed维护链式顺序
        handlerChain.get(index++).executor(this);
    }

    public void setHandlerChain(List<Chain_handler> handlerChain) {
        this.handlerChain = handlerChain;
    }
}
