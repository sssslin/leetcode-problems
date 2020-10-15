package com.tags.tree.sortedArrayToBST;

import test.BaseSolution;
import test.TreeNode;

/**
 * BST
 * vals(root.left) <= root.val <= vals(root.right)
 *
 * height balanced BST
 * Node(root.left) - Node(root.right) <= 1
 */
public class Solution extends BaseSolution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return treeHelper(nums, 0, nums.length - 1);
    }

    private TreeNode treeHelper(int[] nums, int left, int right) {

        // 退出条件
        if (left > right) return null;

        // 变量修改
        // 通过二分法来保证高度差不超过1
        int m = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[m]);

        // 递归调用
        treeNode.left = treeHelper(nums, left , m - 1);
        treeNode.right = treeHelper(nums, m + 1, right);

        return treeNode;
    }
}
