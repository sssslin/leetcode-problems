package com.tags.tree.SymmetricTree;

import test.TreeNode;

public class Solution {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        boolean flag = isSymmetric(root.left, root.right);

        return flag;
    }

    private static boolean isSymmetric(TreeNode a, TreeNode b) {
        if(a == null || b == null) return a == b;
        return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }

}
