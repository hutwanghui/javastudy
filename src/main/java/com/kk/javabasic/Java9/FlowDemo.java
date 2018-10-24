package com.kk.javabasic.Java9;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

/**
 * Created by hutwanghui on 2018/9/12.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class FlowDemo {
    public static void main(String[] args) {
        //发布者（Publisher）：生产可以被订阅者接收的数据
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
//        MyPublisher<String> publisher = new MyPublisher<>();
        MySubscriber<String> subscriber = new MySubscriber<String>();
        //将订阅者注册仅发布者
        publisher.subscribe(subscriber);

        System.out.println("Publishing data items...");
        String[] items = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        Arrays.asList(items).stream().forEach(i -> publisher.submit(i));
        publisher.close();

        try {
            synchronized ("A") {
                "A".wait();
            }
        } catch (InterruptedException ie) {
        }


    }
}
