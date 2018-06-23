package com.kk.datastructure.BinaryTree;

/**
 * Created by msi- on 2018/6/6.
 */
public class Node {
    int value;
    Node leftNode;
    Node rightNode;

    Node(int value) {
        this.value = value;
    }

    public void display() {
        System.out.print(this.value + "\t");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.valueOf(value);
    }
}
