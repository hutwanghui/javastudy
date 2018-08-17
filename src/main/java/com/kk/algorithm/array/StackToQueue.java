package com.kk.algorithm.array;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import java.util.Stack;

/**
 * 两个栈实现队列的先进先出
 * 即每次poll的时候都将栈1的元素全部（不能留）导入栈2，然后将栈2的栈顶弹出，再将栈2的所有元素压回栈1
 * add是同栈的压占
 */
public class StackToQueue {
    private Stack<Integer> stack;
    private Stack<Integer> queue;

    public StackToQueue() {
        this.stack = new Stack<Integer>();
        this.queue = new Stack<Integer>();
    }

    public void add(Integer value) {
        stack.push(value);
    }

    public Integer poll() {
        if (stack.isEmpty() && queue.isEmpty()) {
            throw new RuntimeException("========队列空=========");
        }
        dao();
        int result = queue.pop();
        dao_2();
        return result;
    }

    public Integer peek() {
        if (stack.isEmpty() && queue.isEmpty()) {
            throw new RuntimeException("========队列空=========");
        }
        dao();
        int result = queue.peek();
        dao_2();
        return result;
    }

    public void dao() {
        if (queue.isEmpty()) {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
    }

    public void dao_2() {
        if (stack.isEmpty()) {
            while (!queue.isEmpty()) {
                stack.push(queue.pop());
            }
        }
    }
    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.add(1);
        stackToQueue.add(2);
        System.out.println("peek()" + stackToQueue.peek() + ": poll()" + stackToQueue.poll());

    }

}
