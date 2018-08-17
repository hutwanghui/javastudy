package com.kk.algorithm.array;

/**
 * Created by hutwanghui on 2018/7/28.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

import com.kk.algorithm.util.ArrayUtils;

import java.util.Arrays;

/**
 * 通过数组实现栈的数据结构
 */
public class ArrayStack {
    private int[] arr;
    private int index;
    public void push(int value) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("======栈满！！！！======");
        }
        //先赋值再自增，使得index始终指向栈顶
        arr[index++] = value;
    }
    public int pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("======栈空！！！！======");
        }
        //先自减再赋值使得栈顶指针指向栈顶元素
        int result = arr[--index];
        arr[index] = 0;
        return result;
    }
    //获取栈顶元素
    public int getPeek() {
        if (index == 0) {
            return Integer.valueOf(null);
        }
        return arr[index - 1];
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "arr=" + Arrays.toString(arr) +
                ", index=" + index +
                '}';
    }

    public ArrayStack(int length) {
        this.arr = new int[length];
        this.index = 0;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(1);
        arrayStack.push(2);
        System.out.println(arrayStack.toString());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.toString());
    }
}
