package com.kk.algorithm.TreeNode;

/**
 * Created by hutwanghui on 2018/7/27.
 * email:zjjhwanhui@163.com
 * qq:472860892

/**
 *输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */



import java.util.Arrays;
import java.util.Stack;

/**
 * 思路：
 * 前序遍历序列的第一个数（后序遍历的最后一个数）一定是根结点，
 * 所以可以根据此结点在中序序列中的位置把中序序列分为左子树和右子数两个部分，
 * 同样的道理，在左子树和右子数中同样可以用到这样的规律来确定每个中间结点。
 */


public class rebuild_binaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        } else if (pre.length == 1) {
            return new TreeNode(pre[0]);
        } else {
            TreeNode treeNode = buildBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
            return treeNode;
        }
    }

    public TreeNode buildBinaryTree(int[] pre, int pre_left, int pre_right, int[] in, int in_left, int in_right) {
        if (pre_left > pre_right) {
            //开始位置大于结束位置说明没有需要处理的元素了
            return null;
        }
        //取先序遍历的第一个元素作为根节点
        int root = pre[pre_left];
        int index = in_left;
        while (index <= in_right && in[index] != pre[pre_left]) {
            index++;
        }
        TreeNode treeNode = new TreeNode(root);
        treeNode.left = buildBinaryTree(pre, pre_left + 1, pre_left + index - in_left, in, in_left, index - 1);
        treeNode.right = buildBinaryTree(pre, pre_left + index - in_left + 1, pre_right, in, index + 1, in_right);
        return treeNode;
    }

    //递归方法实现-先序遍历
    public void preTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preTree(treeNode.left);
        preTree(treeNode.right);
    }

    //先将头节点压入栈中
    //每次从栈中弹出栈顶元素，记作current，并打印current.val
    //先看current的右孩子是否为空，不为空则压入，然后看左孩子，不为空则压入
    //不断重复直到栈空
    public void preTreeNoDg(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void midTree(TreeNode head) {
        if (head == null) {
            return;
        }
        midTree(head.left);
        System.out.println(head.val);
        midTree(head.right);
    }

    public void midTreeNoDg(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = head;
        stack.push(head);
        while (!stack.isEmpty()) {
            if (current != null) {
                if (current.left != null)
                    stack.push(current.left);

                else {
                    if (current.right != null) {
                        stack.push(current.right);
                    }
                }
                current = current.left;
            } else {
                TreeNode beforeCurrent = stack.pop();
                System.out.println(beforeCurrent.val);
                current = beforeCurrent.right;
            }
        }


    }

    public void afterTree(TreeNode head) {
        if (head == null) {
            return;
        }
        afterTree(head.left);
        afterTree(head.right);
        System.out.println(head.val);
    }


    public static void main(String[] args) {
        rebuild_binaryTree re = new rebuild_binaryTree();
        /*int pre[]={1,2,4,7,3,5,6,8};
        int in[]={4,7,2,1,5,3,8,6};*/
        int pre[] = {1, 2, 4, 3, 5, 6};
        int in[] = {4, 2, 1, 5, 3, 6};
        TreeNode root = re.reConstructBinaryTree(pre, in);
//        re.preTree(root);
//        System.out.println("=======");
//        re.preTreeNoDg(root);

        re.midTree(root);
        System.out.println("=======");
        re.midTreeNoDg(root);


    }

}
