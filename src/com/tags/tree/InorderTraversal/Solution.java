package com.tags.tree.InorderTraversal;

import test.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        inorder(root, list);
        return list;

    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}