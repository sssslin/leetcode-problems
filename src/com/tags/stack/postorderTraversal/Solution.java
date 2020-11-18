package com.tags.stack.postorderTraversal;

import test.BaseSolution;
import test.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
// 示例 1：
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 示例 2：
//输入：root = []
//输出：[]
// 示例 3：
//输入：root = [1]
//输出：[1]
// 示例 4：
//输入：root = [1,2]
//输出：[1,2]
// 示例 5：
//输入：root = [1,null,2]
//输出：[1,2]
// 提示：
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 454 👎 0
public class Solution extends BaseSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // result唯一的职责就是存放最后的结果
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // 将新加的元素设置为链表的第一个元素
            result.addFirst(cur.val);

            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }

        }
        return result;
    }

}
