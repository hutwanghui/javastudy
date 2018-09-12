package com.kk.javabasic.Future;

import scala.Int;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by hutwanghui on 2018/9/11.
 * email:zjjhwanhui@163.com
 * qq:472860892
 * 任务并行且按照提交顺序获取结果。
 */
public class Java8Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();
        //开启多线程池对异步任务进行优化
        //结果一定是5秒，因为10个任务，定长10线程池，其中一个任务耗时3秒，一个任务耗时5秒，由于并发高速轮训，耗时取最长5秒
        ExecutorService exs = Executors.newFixedThreadPool(10);

        //结果集
        List<Integer> list = new ArrayList<Integer>();
        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
        //向任务集中添加任务
        for (int i = 0; i < 10; i++) {
            futureList.add(exs.submit(new CallableTask(i)));
        }
        Long getReulstStartTime = System.currentTimeMillis();
        for (Future future : futureList) {
            //CPU高速轮询：每个future都并发轮循，判断完成状态然后获取结果，
            //即有10个future在高速轮询，完成一个future的获取结果，就关闭一个轮询
            while (true) {
                if (future.isDone() && !future.isCancelled()) {
                    Integer result = (Integer)future.get();
                    System.out.println("任务" + result + "执行完成，用时：" + String.valueOf(System.currentTimeMillis() - getReulstStartTime));
                    list.add(result);
                    break;
                }
            }
        }
        System.out.println(list);
        System.out.println("总耗时：" + (System.currentTimeMillis() - start));
    }

    static class CallableTask implements Callable {

        Integer i;

        public CallableTask(Integer i) {
            super();
            this.i = i;
        }

        @Override
        public Integer call() throws Exception {
            if (i == 1) {
                //任务1耗时3000
                Thread.sleep(3000);
            } else if (i == 5) {
                Thread.sleep(5000);
            } else {
                Thread.sleep(1000);
            }
            System.out.println("task线程：" + Thread.currentThread().getName() + "任务i=" + i + ",完成！");
            return i;
        }
    }
}
