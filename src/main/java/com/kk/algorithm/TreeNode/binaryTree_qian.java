package com.kk.algorithm.TreeNode;

/**
 * Created by hutwanghui on 2018/8/10.
 * email:zjjhwanhui@163.com
 * qq:472860892
 */
public class binaryTree_qian {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归方法实现
    public void preTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preTree(treeNode.left);
        preTree(treeNode.right);
    }

    public static void main(String[] args) {

    }
}
