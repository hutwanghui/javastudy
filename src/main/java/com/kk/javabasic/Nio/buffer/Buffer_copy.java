package com.kk.javabasic.Nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by hutwanghui on 2018/8/3.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Buffer_copy {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("F:\\home\\fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("F:\\home\\toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count = fromChannel.size();

        //transferFrom()方法可以将数据从源通道传输到FileChannel中(从来源拷贝到自己)
        toChannel.transferFrom(fromChannel, position, count);
        //transferTo()：将自己拷贝给他人
        fromChannel.transferTo(position, count, toChannel);
    }
}
