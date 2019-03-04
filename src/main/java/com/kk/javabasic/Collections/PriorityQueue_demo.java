package com.kk.javabasic.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hutwanghui on 2018/10/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 * 优先队列。优先队列的作用是能保证每次取出的元素都是队列中权值最小的
 * 元素大小的评判可以通过元素本身的自然顺序（natural ordering），也可以通过构造时传入的比较器（Comparator
 */
public class PriorityQueue_demo {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add("test001");
        priorityQueue.add("test003");
        priorityQueue.add("test002");
        priorityQueue.add("test004");
        priorityQueue.add("test006");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    public static void bfs(HashMap<Character, PriorityQueue<Character>> graph, HashMap<Character, Integer> dist,
                           char start) {
        Queue<Character> q = new PriorityQueue<>();
        q.add(start);
        dist.put(start, 0);
        int i = 0;
        while (!q.isEmpty()) {
            char top = q.poll();
            i++;
            System.out.println("The " + i + "th element:" + top + " Distance from s is:" + dist.get(top));
            int d = dist.get(top) + 1;
            for (Character c : graph.get(top)) {
                if (!dist.containsKey(c)) {
                    dist.put(c, d);
                    q.add(c);
                }
            }
        }
    }
}
