package com.kk.javabasic.Nio;

/**
 * Created by msi- on 2018/6/23.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务线程在等待IO（因为accept，read，write都是阻塞式的）
 * 让高速运行的CPU去等待及其低效的网络IO是非常不合算的行为
 */
public class NioClent implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(NioClent.class);
    private SocketChannel socketChannel;
    private SelectionKey key;
    private Selector selector;
    private final static int port = 8686;
    private final static int BUF_SIZE = 10240;
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);

    public NioClent(int port) throws IOException {
        initClient(port);
    }

    public void initClient(int port) {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress(port));
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Connect(SelectionKey key) throws IOException {
        socketChannel = (SocketChannel) key.channel();
        while (true) {
            //如果建立完成了，退出循环
            if (socketChannel.finishConnect())
                break;
        }
        socketChannel.configureBlocking(false);
        String info = "我是" + Thread.currentThread().getName() + "的客户端进程，服务端你好!!";
        byteBuffer.clear();
        byteBuffer.put(info.getBytes("UTF-8"));
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        socketChannel.close();
    }

    public void Read(SelectionKey key) throws IOException {
        socketChannel = (SocketChannel) key.channel();
        socketChannel.read(byteBuffer);
        byte[] data = byteBuffer.array();
        String msg = new String(data).trim();
        System.out.println("接收来自服务端发送消息：" + msg);
        socketChannel.close();
        key.selector().close();
    }

    private void Write(SelectionKey key) throws IOException {
        byteBuffer = ByteBuffer.allocate(BUF_SIZE);
        String info = "主动向服务端发送写请求";
        byteBuffer.clear();
        byteBuffer.put(info.getBytes("UTF-8"));
        byteBuffer.flip();
        socketChannel = (SocketChannel) key.channel();
        while (byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }
        byteBuffer.compact();
    }

    //统一的事件分派中心-> dispatch
    private void dispatch(SelectionKey key) throws Exception {

        if (key.isConnectable()) {
            Connect(key);//新链接建立，注册
        } else if (key.isReadable()) {
            Read(key);//读事件处理
        } else if (key.isWritable()) {
            Write(key);//写事件处理
        }
    }

    @Override
    public void run() {
        try {
            while (true) {       //轮询
                selector.select();          //这是一个阻塞方法，一直等待直到有数据可读，返回值是key的数量（可以有多个）
                Set keys = selector.selectedKeys();         //如果channel有数据了，将生成的key访入keys集合中
                Iterator iterator = keys.iterator();        //得到这个keys集合的迭代器
                while (iterator.hasNext()) {             //使用迭代器遍历集合
                    SelectionKey key = (SelectionKey) iterator.next();       //得到集合中的一个key实例
                    iterator.remove();          //拿到当前key实例之后记得在迭代器中将这个元素删除，非常重要，否则会出错
                    dispatch(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            NioClent nioClent = new NioClent(8999);
            pool.execute(nioClent);
        }
        pool.shutdown();

    }
}
