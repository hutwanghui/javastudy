package com.kk.algorithm.array;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实际上将队列改编成栈结构无非就是将先进先出的规则改变成先进后出，因此我们可以使用
 * 两个队列的结构来实现先进后出
 * 每次要pop栈的时候只在队列中留下队尾的元素，其他元素入另一个队列
 * push是同队列的入队
 */
public class QueueToStack {
    private Queue<Integer> queue;
    private Queue<Integer> stack;

    public QueueToStack() {
        //队列的实现可以是动态数组也可以是
        this.queue = new LinkedList<>();
        this.stack = new LinkedList<>();
    }

    public void push(Integer value) {
        stack.add(value);
    }

    public Integer pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("======栈空======");
        }
        while (stack.size() > 1) {
            queue.add(stack.poll());
        }
        int result = stack.poll();
        swap();
        return result;
    }

    public Integer peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("======栈空======");
        }
        while (stack.size() > 1) {
            queue.add(stack.poll());
        }
        int result = stack.poll();
        queue.add(result);
        swap();
        return result;
    }

    public void swap() {
        Queue<Integer> tmp = queue;
        queue = stack;
        stack = tmp;
    }

    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.push(1);
        queueToStack.push(2);
        System.out.println("peek()" + queueToStack.peek() + ": pop()" + queueToStack.pop());

    }
}
