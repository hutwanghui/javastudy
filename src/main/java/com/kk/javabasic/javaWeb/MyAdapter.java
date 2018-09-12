package com.kk.javabasic.javaWeb;

import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.apache.tomcat.util.buf.ByteChunk;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.tomcat.util.net.SocketEvent;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by hutwanghui on 2018/8/23.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

public class MyAdapter implements org.apache.coyote.Adapter {
    @Override
    public void service(Request request, Response response) throws Exception {
        // 请求处理
        System.out.println("Hi, Boss. I am handling the reuqest!");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(baos));
        writer.println("Not Hello World");
        writer.flush();

        ByteChunk byteChunk = new ByteChunk();
        byteChunk.append(baos.toByteArray(), 0, baos.toByteArray().length);
        response.doWrite(byteChunk);
    }

    @Override
    public boolean prepare(Request request, Response response) throws Exception {
        return false;
    }

    @Override
    public boolean asyncDispatch(Request request, Response response, SocketEvent socketEvent) throws Exception {
        return false;
    }

    @Override
    public void log(Request request, Response response, long l) {

    }

    @Override
    public void checkRecycled(Request request, Response response) {

    }

    @Override
    public String getDomain() {
        return null;
    }
}
