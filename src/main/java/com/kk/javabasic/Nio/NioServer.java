package com.kk.javabasic.Nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by msi- on 2018/6/23.
 */

/**
 * NIO已经解决了上述BIO暴露的同步阻塞、线程数量需要动态指定的问题了，
 * 服务器的并发客户端有了量的提升，不再受限于一个客户端一个线程来处理，
 * 而是一个线程可以维护多个客户端（selector 支持对多个socketChannel 监听）
 * 在这种实现方式中，dispatch方法是同步阻塞的！！！所有的IO操作和业务逻辑处理都在NIO线程（即Reactor线程）中完成。如果业务处理很快，那么这种实现方式没什么问题，不用切换到用户线程。但是，想象一下如果业务处理很耗时（涉及很多数据库操作、磁盘操作等），那么这种情况下Reactor将被阻塞，这肯定是我们不希望看到的。解决方法很简单，业务逻辑进行异步处理,即交给用户线程处理。
 * <p>
 * 下面分析下单线程版的Reactor模型的缺点：
 * <p>
 * 自始自终都只有一个Reactor线程，缺点很明显：Reactor意外挂了，整个系统也就无法正常工作，可靠性太差。
 * 单线程的另外一个问题是在大负载的情况下，Reactor的处理速度必然会成为系统性能的瓶颈。
 */
public class NioServer implements Runnable {


    private static Logger logger = LoggerFactory.getLogger(NioServer.class);
    private final static int port = 8686;
    private final static int BUF_SIZE = 10240;
    private ServerSocketChannel ssc;
    private ServerSocket serverSocket;
    private SocketChannel channel;
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    //基于事件驱动-> selector（支持对多个socketChannel的监听）
    public NioServer(int port) {
        initServer(port);
    }

    public void initServer(int port) {
        try {
            //创建服务端socket，只需要一个线程
            ssc = ServerSocketChannel.open();
            //创建选择器
            selector = Selector.open();
            //调整通道为非阻塞模式，注册通道必须指定为非阻塞模式
            ssc.configureBlocking(false);
            serverSocket = ssc.socket();
            serverSocket.bind(new InetSocketAddress(port));
            System.out.println("服务器正在监听:" + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
            //将上述的通道管理器和通道绑定，并为该通道注册OP_ACCEPT事件
            //注册事件后，当该事件到达时，selector.select()会返回（一个key），如果该事件没到达selector.select()会一直阻塞
            ssc.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //统一的事件分派中心-> dispatch
    private void dispatch(SelectionKey key) throws Exception {
        if (key.isAcceptable()) {
            register(key);//新链接建立，注册
        } else if (key.isReadable()) {
            read(key);//读事件处理
        } else if (key.isWritable()) {
            write(key);//写事件处理
        } else {
            System.out.println("=======");
        }
    }

    //注册中心，用于新新连接的建立
    private void register(SelectionKey key) throws Exception {
        serverSocketChannel = (ServerSocketChannel) key.channel();
        // 获得和客户端连接的通道
        logger.info("=======Nio服务端正在循环监听========");
        channel = serverSocketChannel.accept();
        channel.configureBlocking(false);
        //客户端通道注册到selector 上
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        channel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
        long bytesRead = channel.read(byteBuffer);
        while (bytesRead > 0) {
            byteBuffer.flip();
            byte[] data = byteBuffer.array();
            String info = new String(data).trim();
            System.out.println("从客户端发送过来的消息是：" + info);
            byteBuffer.clear();
            bytesRead = channel.read(byteBuffer);
        }

        ByteBuffer buf = ByteBuffer.allocate(1024);
        channel.read(buf);//
        buf.put("123456".getBytes());
        //   channel.register(this.selector, SelectionKey.OP_WRITE);
//        if (bytesRead == -1) {
//            channel.close();
//        }
    }

    private void write(SelectionKey key) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
        System.out.println("回消息");
        String info = "你好客户端，我已收到你发出的请求";
        byteBuffer.clear();
        byteBuffer.put(info.getBytes("UTF-8"));
        byteBuffer.flip();
        channel = (SocketChannel) key.channel();
        while (byteBuffer.hasRemaining()) {
            channel.write(byteBuffer);
        }
        byteBuffer.compact();
        //channel.register(selector, SelectionKey.OP_READ);
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

    public static void main(String[] args) {
        NioServer myNioServer = new NioServer(8999);
        myNioServer.run();
    }
}
