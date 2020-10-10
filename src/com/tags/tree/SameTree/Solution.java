package com.tags.tree.SameTree;

import test.TreeNode;

import java.util.Stack;

public class Solution {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // p、q同时等于0
        if (p == null && q == null) return true;
        // p、q其中一个为0
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

}
