package com.kk.javabasic.Design.Chain;

import java.util.List;

/**
 * Created by hutwanghui on 2018/8/19.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public abstract class Chain_handler {

    public void executor(Chain chain) {
        handlerProcessor();
        //递归调用
        chain.procceed();
    }

    public abstract void handlerProcessor();
}
