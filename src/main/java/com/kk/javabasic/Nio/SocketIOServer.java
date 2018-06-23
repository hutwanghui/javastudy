package com.kk.javabasic.Nio;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by msi- on 2018/6/23.
 */
public class SocketIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2000);
        System.out.println("等待，端口是：" + serverSocket.getLocalPort());
        while (true) {
            //使用accept阻塞方法接收消息
            Socket socket = serverSocket.accept();
            System.out.println("接收到客户端" + socket.getInetAddress() + "的连接请求！端口号是：" + socket.getPort());
            //从socket中获取输入流
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //使用byte数组接收输入流中的内容
            byte[] byteArray = new byte[1024];
            while (dataInputStream.read(byteArray, 0, 1024) != -1) {
                System.out.println(">>>>>>>>>>>客户端发来的内容>>>>>>>>>>");
                System.out.println(new String(byteArray, "utf-8"));
            }
            socket.close();
            System.out.println("连接由客户端发起关闭");
        }
    }
}
