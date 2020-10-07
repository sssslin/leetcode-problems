package com.tags.tree;

public class SymmetricTree {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        boolean flag = isSymmetric(root.left, root.right);

        return flag;
    }

    private static boolean isSymmetric(TreeNode a, TreeNode b) {
        if(a == null || b == null) return a == b;
        return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
