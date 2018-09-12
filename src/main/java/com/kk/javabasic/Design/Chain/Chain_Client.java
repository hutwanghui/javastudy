package com.kk.javabasic.Design.Chain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hutwanghui on 2018/8/19.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Chain_Client {
    static class ChainHandlerA extends Chain_handler {

        @Override
        public void handlerProcessor() {
            System.out.println("This is A handler");
        }
    }

    static class ChainHandlerB extends Chain_handler {

        @Override
        public void handlerProcessor() {
            System.out.println("This is B handler");
        }
    }

    static class ChainHandlerC extends Chain_handler {

        @Override
        public void handlerProcessor() {
            System.out.println("This is C hadnler");
        }
    }

    public static void main(String[] args) {
        List<Chain_handler> handlers = Arrays.asList(
                new ChainHandlerA(), new ChainHandlerB(), new ChainHandlerC()
        );
        Chain chain = new Chain();
        chain.setHandlerChain(handlers);
        chain.procceed();
    }
}

