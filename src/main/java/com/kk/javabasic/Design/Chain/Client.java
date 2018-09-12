package com.kk.javabasic.Design.Chain;

/**
 * Created by hutwanghui on 2018/8/19.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Client {
    static class HandlerA extends Handler {
        @Override
        public void handlerProcessor() {
            System.out.println("This ia A handler");
        }
    }

    static class HandlerB extends Handler {
        @Override
        public void handlerProcessor() {
            System.out.println("This is B handler");
        }
    }

    static class HandlerC extends Handler {
        @Override
        public void handlerProcessor() {
            System.out.println("This is C handler");
        }
    }

    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        handlerA.executor();

    }
}
