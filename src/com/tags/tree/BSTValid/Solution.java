package com.tags.tree.BSTValid;

import test.TreeNode;

/**
 * 树的题目，最核心的思想是递归，而递归最匹配的数据结构就是栈Stack
 *
 * 另外，脑子里要想到的是，如何遍历，前序，中序，还是后序，还是层次遍历
 *
 * 还是深度优先和广度优先
 *
 * 另外还有一个核心的地方就是，边界情况，如何去判断
 *
 * 每种解法对应的时间复杂度，空间复杂度，数据规模，等等各种情况
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;

        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return helper(root.left, min, root.val) &&
                helper(root.right, root.val, max);
    }


}