package com.kk.javabasic.Thread.Hystrix;

import com.netflix.hystrix.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by hutwanghui on 2018/7/31.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class DingdanService_Thread extends HystrixCommand<String> {

    private static Logger logger = LoggerFactory.getLogger(DingdanService_Thread.class);

    private String orderName;

    public DingdanService_Thread(String orderName) {
        super(Setter
                //服务分组,一个服务group使用一个线程池
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("DINGDAN"))
                //线程池分组
                //.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("DingdanPool"))
                //线程池的配置
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        //线程池中的线程数DINGDAN-1-2-3
                        .withCoreSize(3)
                        //最大执行线程数
                        .withMaximumSize(5)
                        .withKeepAliveTimeMinutes(5)
                        //设置使用哪种BlockingQueue，如果-1为SynchronousQueue；其他则为LinkedBlockingQueue
                        .withMaxQueueSize(-1)
                        //队列reject阈值，可以动态修改
                        .withQueueSizeRejectionThreshold(10000)
                )
                //线程池隔离配置
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        //设置run方法的最大并发数,需要和withCoreSize，withMaxQueueSize共同来判断
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(3)
                        //超时时间,HystrixCommand被标记为TIMEOUT，并执行回退逻辑。
                        .withExecutionTimeoutInMilliseconds(200)
                        //设置线程隔离策略
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                )
        );
        this.orderName = orderName;
    }

    @Override
    protected String run() throws Exception {
        logger.info("====订单名称:====" + orderName);
        //休息100毫秒，TimeUnit也是Concurrent包下的工具，在这里会触发fallback，因为指定了超时的时限
        if (orderName.equals("TM120005")) {
            TimeUnit.MILLISECONDS.sleep(200);
        }
        //主动抛出异常，也会触发fallback
        if (orderName.equals("TM120006")) {
            throw new IllegalThreadStateException("=====主动抛出的异常啊啊啊=====");
        }
        return "OrderName:" + orderName;
    }

    @Override
    protected String getFallback() {
        logger.info("=======服务降级======");
        //在fallback里可以通过this.getExecutionException()获取执行run过程中抛出的异常，除了HystrixBadRequestException外。
        return "testOrderName";
    }

    public static void main(String[] args) {
        //模拟并发量为5的情况

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String orderName = "TM12000" + random.nextInt(10);
                    System.out.println("正在并发处理业务代码" + new DingdanService_Thread(orderName).execute());
                }
            });
            thread.start();
        }
    }
}
