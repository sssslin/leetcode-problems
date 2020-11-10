package com.tags.list.sortedListToBST;

import test.BaseSolution;
import test.ListNode;
import test.TreeNode;

import java.util.ArrayList;

//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
// 示例:
// 给定的有序链表： [-10, -3, 0, 5, 9],
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// Related Topics 深度优先搜索 链表

/**
 * 思路分析：给定一个有序链表，转换成一个高度平衡的BST
 * <p>
 * 那么首先要分析一下BST的性质
 * leftTree < root < rightTree
 * 并且要求高度差的绝对值不超过1
 * <p>
 * 根据数据范围可以反推，用二分法去做是完全没问题的
 * 以下这种解法的关键在于 二分 + 递归，并且用一个数组辅助，采用了空间换时间的做法
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--24/
 * time: O(log(n)) space:O(n)
 */
public class Solution extends BaseSolution {
    public TreeNode sortedListToBST(ListNode head) {

        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        return sortedArrayToBST(nums);
    }

    private TreeNode sortedArrayToBST(ArrayList<Integer> nums) {
        return sortedArrayToBST(nums, 0, nums.size());
    }

    private TreeNode sortedArrayToBST(ArrayList<Integer> nums, int start, int end) {
        if (start == end) return null;

        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums.get(mid));
        // 改变范围，进行递归
        root.left = sortedArrayToBST(nums, start, mid);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }


}
