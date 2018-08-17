package com.kk.algorithm.LinkedList;

import java.util.Stack;

/**
 * Created by hutwanghui on 2018/7/29.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class IsHuiWen {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isHuiWenNotUseStack(Node node) {
        return true;
    }

    public static boolean isHuiWenUseStack(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node push = head;
        while (push.next != null) {
            stack.push(push.next);
            push = push.next;
        }
        Node pop = head;
        while (pop.next != null) {
            if (pop.value != stack.pop().value) {
                return false;
            }
            pop = pop.next;
        }
        return true;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println("是否是回文链表" + isHuiWenUseStack(head));
    }
}
