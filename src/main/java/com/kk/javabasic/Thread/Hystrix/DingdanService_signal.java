package com.kk.javabasic.Thread.Hystrix;

import com.netflix.hystrix.*;
import org.joda.time.DateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by hutwanghui on 2018/7/31.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class DingdanService_signal extends HystrixCommand<List<Order>> {

    private static Logger logger = LoggerFactory.getLogger(DingdanService_signal.class);

    private List<Order> orders;

    public DingdanService_signal(List<Order> orders) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ORDER_SIGNAL"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ORDER_POOL_SIGNAL"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter())
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        //由于信号量隔离下无论调用哪种命令执行方法，hystrix都不会创建新线程执行run()/construct()
                        // 所以调用程序需要自己创建多个线程来模拟并发调用execute()，最后看到一旦并发线程>3，后续请求都进入fallback
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(2)
                )
        );

        //由于设置了信号量是2，所以超过2的线程都没有执行run而是执行了降级
        //[Thread-3] INFO com.kk.javabasic.Thread.Hystrix.DingdanService_signal
        // getFallback(): 线程名是Thread-3
        //[Thread-1] INFO com.kk.javabasic.Thread.Hystrix.DingdanService_signal -
        //getFallback(): 线程名是Thread-1
        //[Thread-2] INFO com.kk.javabasic.Thread.Hystrix.DingdanService_signal -
        //getFallback(): 线程名是Thread-2
        // [Thread-0] INFO com.kk.javabasic.Thread.Hystrix.DingdanService_signal -
        // run(): 线程名是Thread-0
        // [Thread-4] INFO com.kk.javabasic.Thread.Hystrix.DingdanService_signal -
        // run(): 线程名是Thread-4

        this.orders = orders;
    }


    @Override
    protected List<Order> run() throws Exception {
        logger.info("\nrun(): 线程名是" + Thread.currentThread().getName() + "\n");
        //这里的操作是让id+100，如果线程数目超过信号量的部分，就不会执行这个
        orders.stream().forEach(order -> order.setId(order.getId() + 100));
        return orders;
    }

    @Override
    protected List<Order> getFallback() {
        logger.info("\ngetFallback(): 线程名是" + Thread.currentThread().getName() + "\n");
        return orders;
    }


    public static void main(String[] args) {
        List<Order> orders = new ArrayList<Order>();
        List<Order> orders1 = new ArrayList<Order>();
        List<Order> orders2 = new ArrayList<Order>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Order o = new Order(i, "TMGJ00" + i, new Date(), random.nextDouble());
            Order o1 = new Order(i, "JD00" + i, new Date(), random.nextDouble());
            Order o2 = new Order(i, "SN00" + i, new Date(), random.nextDouble());
            orders.add(o);
            orders1.add(o1);
            orders2.add(o2);
        }
        //由主线程创建线程来模拟并发情况
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("=====并发处理线程====" + new DingdanService_signal(orders).execute());
                }
            });
            thread.start();
        }


        System.out.println("------开始打印现有线程---------");
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Thread thread : map.keySet()) {
            System.out.println(thread.getName());
        }
        System.out.println("thread num: " + map.size());
    }


}
