package com.tags.tree.BuildTree2;

import test.BaseSolution;
import test.TreeNode;

public class Solution extends BaseSolution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || postorder.length != inorder.length) return null;

        return builderTreeHelper(inorder, postorder, 0, 0, inorder.length);
    }

    private TreeNode builderTreeHelper(int[] inorder, int[] postorder, int inStart, int postStart, int size) {

        if (size == 0) return null;

        TreeNode node = new TreeNode(postorder[postStart + size - 1]);

        int inorderIndex = inStart;
        while (inorder[inorderIndex] != postorder[postStart + size - 1]) {
            inorderIndex++;
        }

        int leftSize = inorderIndex - inStart;
        int rightSize = size - leftSize - 1;

        TreeNode leftNode = builderTreeHelper(inorder, postorder, inStart, postStart, leftSize);
        TreeNode rightNode = builderTreeHelper(inorder, postorder, inorderIndex + 1, postStart + leftSize, rightSize);

        node.left = leftNode;
        node.right = rightNode;

        return node;
    }

}
