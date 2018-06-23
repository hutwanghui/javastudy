package com.kk.javabasic.Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by msi- on 2018/6/23.
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        //创建socket channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        ServerSocket serverSocket = channel.socket();
        //地址重用
        serverSocket.setReuseAddress(true);
        //绑定服务器的地址和端口
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 2100));
        System.out.println("服务器正在监听:" + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
        //分配一个字节缓冲区,这个缓冲是nio新增的，java.nio.ByteBuffer
        ByteBuffer byteBuffer=ByteBuffer.allocate(4096);
        //读取数据

    }
}
