package com.kk.javabasic.Nio;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by msi- on 2018/6/23.
 */
public class SocketIOClient {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        //创建socket连接
        Socket socket = new Socket("127.0.0.1", 2000);
        System.out.println("客户端正在连接服务器： " + socket.getInetAddress()
                + ":" + socket.getPort());
        FileInputStream fileInputStream = new FileInputStream("F:\\IDEAworkspace\\javastudy\\src\\main\\java\\com\\kk\\javabasic\\Nio\\test.txt");
        // 输出文件
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        // 缓冲区4096K
        byte[] b = new byte[1024];
        // 传输长度
        long read = 0, total = 0;
        // 读取文件，写到socketio中
        while ((read = fileInputStream.read(b)) >= 0) {
            total = total + read;
            output.write(b);
        }
        // 关闭
        output.close();
        fileInputStream.close();
        socket.close();
        // 打印时间
        System.out.println("数据传输总大小：" + total + "数据传输总时间："
                + (System.currentTimeMillis() - start));
    }
}
