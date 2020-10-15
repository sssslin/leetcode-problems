package com.tags.tree.minDepth;

import test.BaseSolution;
import test.TreeNode;

public class Solution extends BaseSolution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    private int getHeight(TreeNode node) {
        // 退出条件
        if (node == null) return -1;

        int l = getHeight(node.left) + 1;
        int r = getHeight(node.right) + 1;
        return Math.min(l, r);
    }
}
