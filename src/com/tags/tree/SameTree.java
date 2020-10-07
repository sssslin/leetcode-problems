package com.tags.tree;

import java.util.Stack;

public class SameTree {

    public static void main(String[] args) {

        TreeNode ptree = new TreeNode();
        ptree.val = 1;
        ptree.left = new TreeNode(2);
        ptree.right = new TreeNode(3);
        TreeNode qtree = new TreeNode();
        qtree.val = 1;
        qtree.left = new TreeNode(2);
        qtree.right = new TreeNode(3);
        boolean flag = isSameTree(ptree, qtree);
        System.out.println(flag);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // p、q同时等于0
        if (p == null && q == null) return true;
        // p、q其中一个为0
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
