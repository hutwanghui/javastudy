package com.kk.algorithm.array;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */

/**
 * 题目描述
 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */

/**
 * 思路：
 * 利用栈的先进后出的特点，最后分别结点进行出栈操作，并将结点的值添加到一个列表中，这样就能从尾到头打印每个节点的值
 */
public class ListNodeToArrayList {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> arrayList=new ArrayList<>();
        while(listNode!=null){
            stack.push(listNode.val);
            if(listNode.next!=null){
                listNode=listNode.next;
            }else{
                break;
            }
        }
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

}
