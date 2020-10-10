package com.tags.tree.BuildTree1;

import test.TreeNode;

public class Solution {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
                || preorder.length == 0 || inorder.length == 0) return null;

        return builderTreeHelper(preorder, inorder, 0, 0, preorder.length - 1);
    }

    private static TreeNode builderTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {

        if (preStart > preorder.length || inStart > inEnd) return null;

        TreeNode current = new TreeNode(preorder[preStart]);
        int i = inStart;
        while (i <= inEnd) {
            if (inorder[i] == preorder[preStart]) break;
            i++;
        }

        current.left = builderTreeHelper(preorder, inorder, preStart + 1, inStart, i - 1);
        current.right = builderTreeHelper(preorder, inorder, preStart + (i - inStart + 1), i + 1, inEnd);

        return current;
    }

}
