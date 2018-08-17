package com.kk.javabasic.Thread.Hystrix;

import com.netflix.hystrix.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by hutwanghui on 2018/7/31.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class UserService_Thread extends HystrixCommand<String> {

    private static Logger logger = LoggerFactory.getLogger(UserService_Thread.class);

    private String userName;

    public UserService_Thread(String userName) {
        super(Setter
                //服务分组
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("USER"))
                //线程池分组
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("UserPool"))
                //线程池的配置
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(4)
                        .withKeepAliveTimeMinutes(5)
                        //队列大小
                        .withMaxQueueSize(10)
                        //队列reject阈值，可以动态修改
                        .withQueueSizeRejectionThreshold(10000)
                )
                //线程池隔离配置
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        //超时时间,即执行fallback的时间
                        .withExecutionTimeoutInMilliseconds(1000)
                        //设置线程隔离策略
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                )
        );
        this.userName = userName;
    }

    @Override
    protected String run() throws Exception {
        logger.info("====用户名称:====" + userName);
        //休息100毫秒，TimeUnit也是Concurrent包下的工具
        TimeUnit.MILLISECONDS.sleep(500);
        return "OrderName:" + userName;
    }

    @Override
    protected String getFallback() {
        logger.debug("=======服务降级======");
        return "testOrderName";
    }
}
