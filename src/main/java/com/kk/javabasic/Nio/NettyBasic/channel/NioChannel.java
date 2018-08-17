package com.kk.javabasic.Nio.NettyBasic.channel;

import com.kk.javabasic.Nio.NettyBasic.ChannelHandler;
import com.kk.javabasic.Nio.NettyBasic.Reactor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/**
 * 客户端的SocketChannel,主要用来连接
 * 1.通过SocketChannel.connect()连接到远程服务器
 * 2.创建读数据/写数据缓冲区对象来读取服务端数据或向服务端发送数据
 * 3.关闭SocketChannel
 * <p>
 * 服务端的ServerSocketChannel，主要用来监听
 * 1.通过ServerSocketChannel 绑定ip地址和端口号
 * 2.通过ServerSocketChannelImpl的accept()方法创建一个SocketChannel对象用户从客户端读/写数据
 * 3.创建读数据/写数据缓冲区对象来读取客户端数据或向客户端发送数据
 * 4. 关闭SocketChannel和ServerSocketChannel
 * <p>
 * 虽然两者的作用是不相同的，但是他们的绑定、连接、I\O处理实际上是一样的，所以这个类就是用来封装Channel的
 * 并且把selector的分发和buffer的处理下放到reactor和slink去了
 */
public abstract class NioChannel {

    private static final Logger LOG = LoggerFactory.getLogger(NioChannel.class);

    protected Reactor reactor;

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

    public void register(Reactor reactor, int interestOps) {
        this.reactor = reactor;
        try {
            selectionKey = sc.register(reactor().getSelector(), interestOps, this);
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        }
    }

    public abstract void bind(InetSocketAddress remoteAddress) throws Exception;

    public abstract void connect(InetSocketAddress remoteAddress) throws Exception;

    public void handler(ChannelHandler h) {
        handler = h;
    }

    public SelectableChannel channel() {
        return sc;
    }

    public Reactor reactor() {
        return reactor;
    }

    public NioChannelSink sink() {
        return sink;
    }

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
            handler.channelRead(this, bb);
        } catch (Exception e) {
            fireExceptionCaught(e);
        }
    }

    protected void fireExceptionCaught(Throwable t) {
        try {
            handler.exceptionCaught(this, t);
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

    public abstract NioChannelSink nioChannelSink();

    public interface NioChannelSink {

        void doRead();

        void doSend();

        void sendBuffer(ByteBuffer bb);

        void close();
    }
}
