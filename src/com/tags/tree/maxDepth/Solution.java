package com.tags.tree.maxDepth;

import test.BaseSolution;
import test.TreeNode;

public class Solution extends BaseSolution {

    public  int maxDepth(TreeNode root) {
        return 1 + getHeight(root);
    }

    private int getHeight(TreeNode node){
        if(node == null)
            return -1;

        int l = 1+ getHeight(node.left);
        int r = 1+ getHeight(node.right);
        return Math.max(l, r);
    }
}
