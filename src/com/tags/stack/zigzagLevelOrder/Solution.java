package com.tags.stack.zigzagLevelOrder;

import test.BaseSolution;
import test.ListNode;
import test.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 292 👎 0

/**
 * 这道题目的解法有很多，可以使用递归解题，如果不用递归，也可以用队列解题。
 * 如果用栈的话，可以使用 flag + 单个栈 或者双栈的形式来写（一个栈装顺序的数据，一个栈放逆序的数据）
 * 整体的思路是没问题的，但是，细节上，还是太差了，要补强
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Stack<TreeNode> children = new Stack<>();
            List<Integer> list = new ArrayList<>();

            // 这里的一个while，代表的是一层完整的遍历
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                list.add(t.val);
                if(flag) {
                    if(t.right != null) children.push(t.right);
                    if(t.left != null) children.push(t.left);
                } else {
                    if(t.left != null) children.push(t.left);
                    if(t.right != null) children.push(t.right);
                }
            }
            
            flag = !flag;
            stack = children;
            res.add(list);
        }

        return res;
    }
}

