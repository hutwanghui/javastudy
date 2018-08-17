package com.kk.javabasic.Nio.Reactor;

/**
 * Created by hutwanghui on 2018/8/1.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/**
 * 对Nio的抽象，统一
 * java.nio.channels.SocketChannel
 * java.nio.channels.ServerSocketChannel
 * 的公共行为而抽象出的抽象类
 */
public abstract class NioChannel {
    protected NioReactor reactor;

    protected SelectableChannel sc;

    protected SelectionKey selectionKey;

    private NioChannelSink sink;

    protected volatile ChannelHandler handler;

    public NioChannel(SelectableChannel sc) {
        this.sc = sc;
        try {
            sc.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sink = nioChannelSink();
    }

    /*
    NIO编程中SocketChannel或ServerSocketChannel需要注册到多路复用器Selector中。
    那么这里就抽象成了NioChannel和Reactor的交互。
     */
    public void register(NioReactor reactor, int interestOps) {
        this.reactor = reactor;
        try {
            selectionKey = sc.register(reactor().getSelector(), interestOps, this);
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        }
    }

    //绑定，交由子类完成
    public abstract void bind(InetSocketAddress remoteAddress) throws Exception;
    //连接，交由子类完成
    public abstract void connect(InetSocketAddress remoteAddress) throws Exception;

    public void handler(ChannelHandler h) {
        handler = h;
    }

    public SelectableChannel channel() {
        return sc;
    }

    public NioReactor reactor() {
        return reactor;
    }

    public NioChannelSink sink() {
        return sink;
    }


    //NioChannel发送的消息的函数：
    public void sendBuffer(ByteBuffer bb) {
        sink().sendBuffer(bb);
    }

    protected final void enableWrite() {
        int i = selectionKey.interestOps();
        if ((i & SelectionKey.OP_WRITE) == 0) {
            selectionKey.interestOps(i | SelectionKey.OP_WRITE);
        }
    }

    protected final void disableWrite() {
        int i = selectionKey.interestOps();
        if ((i & SelectionKey.OP_WRITE) == 1) {
            selectionKey.interestOps(i & (~SelectionKey.OP_WRITE));
        }
    }

    protected void fireChannelRead(ByteBuffer bb) {
        try {
          //  handler.channelRead(this, bb);
        } catch (Exception e) {
            fireExceptionCaught(e);
        }
    }

    protected void fireExceptionCaught(Throwable t) {
        try {
           // handler.exceptionCaught(this, t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isOpen() {
        return sc.isOpen();
    }

    public void close() {
        sink().close();
    }


    /**
     * 将NioChannel的底层读写功能独立出来。
     * 一方面使NioChannel避免集成过多功能而显得臃肿，
     * 另一方面分离出底层传输协议，
     * 为以后底层传输协议的切换做准备。（TCP vs UDP，NIO、OIO、AIO）
     *
     * @return
     */

    public abstract NioChannelSink nioChannelSink();

    public interface NioChannelSink {

        void doRead();

        void doSend();

        void sendBuffer(ByteBuffer bb);

        void close();
    }

}
