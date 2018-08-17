package com.kk.algorithm.array;

import java.util.Arrays;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class ArrayQueue {
    public int[] arr;
    public int size; //表示当前队列里的元素个数
    public int end;
    public int start;

    public ArrayQueue(int initSize) {
        if (initSize <= 0) {
            throw new ArrayIndexOutOfBoundsException("队列的大小不能为负数或0");
        }
        this.arr = new int[initSize];
        this.size = 0;
        this.start = 0;
        this.end = 0;
    }

    public void push(int value) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("========队列满=======");
        }
        size++;
        arr[end] = value;
        end = getNextIndex(arr.length, end);
    }

    public int poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("========队列空=======");
        }
        size--;
        int result = arr[start];
        arr[start] = 0;
        start = getNextIndex(arr.length, start);
        return result;
    }


    public int getNextIndex(int length, int ptr) {
        return size == length ? 0 : ptr + 1;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                ", end=" + end +
                ", start=" + start +
                '}';
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.push(1);
        arrayQueue.push(3);
        System.out.println(arrayQueue.toString());
        int result = arrayQueue.poll();
        System.out.println(arrayQueue.toString());
        System.out.println(result);
    }
}
