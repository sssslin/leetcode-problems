package com.tags.tree;

import java.util.ArrayList;
import java.util.List;


public class PostorderTraversal {

    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private static void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
