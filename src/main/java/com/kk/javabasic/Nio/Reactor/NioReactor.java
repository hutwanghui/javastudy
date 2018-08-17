package com.kk.javabasic.Nio.Reactor;

/**
 * Created by hutwanghui on 2018/7/31.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用器
 * 相当于有分发功能的Selector
 * 此部分是Reactor 将I/O事件分派给对应的Handler
 */
public class NioReactor implements Runnable {


    private static Logger logger = LoggerFactory.getLogger(NioReactor.class);
    private Selector selector;
    private volatile boolean isShutdown;

    NioReactor() {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("========打开多路复用器失败======", e);
        }
    }

    private int wakeUpTime;

    @Override
    public void run() {
        while (true) {
            try {
                //监听
                getSelector().select(wakeUpTime);
                Set<SelectionKey> keySet = getSelector().selectedKeys();
                Iterator<SelectionKey> keyIterator = keySet.iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    //根据就绪事件进行相应操作
                    processSelectedKey(key);
                    keyIterator.remove();
                }
                if(isShutdown()){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void processSelectedKey(SelectionKey key) {
        try {
            NioChannel nioChannel = (NioChannel) key.attachment();

            if (!nioChannel.isOpen()) {
                logger.warn("trying to do i/o on a null socket");
                return;
            }

            int readyOps = key.readyOps();
            if ((readyOps & (SelectionKey.OP_READ | SelectionKey.OP_ACCEPT)) != 0 || readyOps == 0) {
                nioChannel.sink().doRead();
            }
            if ((readyOps & SelectionKey.OP_WRITE) != 0) {
                nioChannel.sink().doSend();
            }
            if ((readyOps & SelectionKey.OP_CONNECT) != 0) {
                //remove OP_CONNECT
                key.interestOps((key.interestOps() & ~SelectionKey.OP_CONNECT));
            }
        } catch (Throwable t) {
            if (logger.isDebugEnabled()) {
                logger.debug("Throwable stack trace", t);
            }
            closeSocket();
        }
    }

    private void closeSocket() {
        try {
            getSelector().selectNow();

            Set<SelectionKey> keys = selector.selectedKeys();
            for (SelectionKey k : keys) {
                NioChannel ch = (NioChannel) k.attachment();
                ch.sink().close();
            }
        } catch (IOException e) {
            logger.warn("Ignoring exception during close socket, e=" + e);

        }
    }

    public void close() {
        try {

            closeSocket();

            getSelector().close();
            if (logger.isDebugEnabled()) {
                logger.debug("Close selector");
            }
        } catch (IOException e) {
            logger.warn("Ignoring exception during close selector, e=" + e);
        }
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public boolean isShutdown() {
        return isShutdown;
    }

    public void setShutdown(boolean shutdown) {
        isShutdown = shutdown;
    }
}
