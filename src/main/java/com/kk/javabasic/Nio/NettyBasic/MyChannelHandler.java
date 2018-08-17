package com.kk.javabasic.Nio.NettyBasic;

import com.kk.javabasic.Nio.NettyBasic.channel.NioChannel;

import java.nio.ByteBuffer;

/**
 * Created by hutwanghui on 2018/8/1.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class MyChannelHandler implements ChannelHandler {

    //记录接受消息的次数
    public volatile int receiveSize;

    //记录抛出的异常
    public volatile Throwable t;

    @Override
    public void channelActive(NioChannel channel) {

    }

    @Override
    public void channelRead(NioChannel channel, Object msg) throws Exception {
        ByteBuffer bb = (ByteBuffer) msg;

        byte[] con = new byte[bb.remaining()];
        bb.get(con);

        String str = new String(con, 0, con.length);

        String resp = "";
        switch (str) {
            case "request1":
                resp = "response1";
                break;
            case "request2":
                resp = "response2";
                break;
            case "request3":
                resp = "response3";
                break;
            default:
                resp = "Hello Client";
        }

        ByteBuffer buf = ByteBuffer.allocate(resp.getBytes().length);
        buf.put(resp.getBytes());

        receiveSize++;

        channel.sendBuffer(buf);
    }

    @Override
    public void exceptionCaught(NioChannel channel, Throwable t) throws Exception {
        this.t = t;
        channel.close();
    }
}
