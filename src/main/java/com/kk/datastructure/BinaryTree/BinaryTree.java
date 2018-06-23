package com.kk.datastructure.BinaryTree;


/**
 * Created by msi- on 2018/6/6.
 */
public class BinaryTree {
    //获取二叉树的最大深度
    /*
    思路：
    1、二叉树的深度为根节点到最远叶子节点的距离；
    2、递归的判断节点是否为null为null则停止递归；
    3、每次递归深度+1；
    4、判断左树更深还是右树更深。
     */
    public int getDepth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int left = getDepth(node.leftNode);
            int right = getDepth(node.rightNode);
            return left > right ? left + 1 : right + 1;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node node = new Node(1);
        Node leftnode = new Node(2);
        Node rightNode = new Node(3);
        Node leftNode_leftNode = new Node(4);
        Node leftNode_rightNode = new Node(5);
        leftnode.leftNode = leftNode_leftNode;
        leftnode.rightNode = leftNode_rightNode;
        node.leftNode = leftnode;
        node.rightNode = rightNode;
        int depth = binaryTree.getDepth(node);
        System.out.println("深度为：" + depth);

    }

}
