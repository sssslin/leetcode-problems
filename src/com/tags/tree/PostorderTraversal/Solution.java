package com.tags.tree.PostorderTraversal;

import test.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class Solution {

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

}
