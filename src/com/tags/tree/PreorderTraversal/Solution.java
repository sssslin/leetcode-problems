package com.tags.tree.PreorderTraversal;


import test.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 * <p>
 * 中序遍历：左子树---> 根结点 ---> 右子树
 * <p>
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 * <p>
 * 层次遍历：只需按层次遍历即可
 * space: O(1)
 * time:O(n^2)
 */
public class Solution {

    // 数组解法,另外还有一种链表的解法
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preorder(root, list);
        return list;
    }

    public static List<Integer> preorderTraversalByStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // push:将元素压到栈顶
        // pop:将栈顶的元素弹出
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(Integer.valueOf(node.val));
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    private static void preorder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);

    }

}
