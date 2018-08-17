package com.kk.javabasic.Thread.Hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by hutwanghui on 2018/7/31.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {


        //阻塞式 execute

        for (int i = 0; i < 10; i++) {
            DingdanService_Thread d = new DingdanService_Thread("EAS000000" + i);
            UserService_Thread ud = new UserService_Thread("EAS111111" + i);
            String execute = d.execute();
            String execute1 = ud.execute();
        }
        logger.info("======订单服务线程池执行完毕======");

        //异步非阻塞方式 queue

        for (int j = 0; j < 10; j++) {
            UserService_Thread u = new UserService_Thread("Test" + j);
            Future<String> queue = u.queue();
            String value = queue.get(200, TimeUnit.MILLISECONDS);
            System.out.println(value);
        }
        logger.info("======用户服务线程池执行完毕======");
        //[hystrix-DingdanPool-1] INFO com.kk.javabasic.Thread.Hystrix.DingdanService_Thread - ====订单名称:====EAS0000001
        //[hystrix-UserPool-1] INFO com.kk.javabasic.Thread.Hystrix.UserService_Thread - ====用户名称:====WANGHUI
        //从结果上可以很明显的看出，两个线程池是不一样的
    }
}
