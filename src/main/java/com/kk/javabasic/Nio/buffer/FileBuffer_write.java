package com.kk.javabasic.Nio.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by hutwanghui on 2018/8/3.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class FileBuffer_write {
    public static void main(String[] args) throws IOException {
//        创建随机访问文件流，以从File参数指定的文件中读取，并可选择写入文件。
//        RandomAccessFile(File file, String mode)
//        创建随机访问文件流，以从中指定名称的文件读取，并可选择写入文件。
//        RandomAccessFile(String name, String mode)
        RandomAccessFile randomAccessFile = new RandomAccessFile("F:\\home\\test2.txt", "rw");

        //覆盖
//        randomAccessFile.writeUTF("ABCDEFG");
        //追加
//        randomAccessFile.seek(randomAccessFile.length());
//        randomAccessFile.writeUTF("ZZZZZZZ");

        //使用buffer的覆盖和追加
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("这是一个使用channel覆盖的demo".getBytes());
        byteBuffer.flip();
        //因为无法保证write()方法一次能向FileChannel写入多少字节，因此需要重复调用write()方法，直到Buffer中已经没有尚未写入通道的字节。
        while (byteBuffer.hasRemaining())
            fileChannel.write(byteBuffer);
        fileChannel.close();
    }
}
