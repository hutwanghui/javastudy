package com.kk.javabasic.Nio.Reactor;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by hutwanghui on 2018/8/1.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 多线程版本的Reactor
 * 改进方向
 接受客户端连接请求的不在是单个线程-Acceptor，而是一个NIO线程池。
 I/O处理也不再是单个线程处理，而是交给一个I/O线程池进行处理。
 */
public class NioServerHandler implements ChannelHandler{

}
