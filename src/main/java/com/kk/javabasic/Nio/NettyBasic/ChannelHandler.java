package com.kk.javabasic.Nio.NettyBasic;


import com.kk.javabasic.Nio.NettyBasic.channel.NioChannel;

/**
 * netty实际上就暴露了这块内容给用户编写业务逻辑代码
 * 分为IN和OUT两个链式的handler链
 */
public interface ChannelHandler {

    //客户端连接服务器后被调用
    void channelActive(NioChannel channel);

    //从服务端接收数据后调用
    void channelRead(NioChannel channel, Object msg) throws Exception;

    //异常捕获后调用
    void exceptionCaught(NioChannel channel, Throwable t) throws Exception;
}
