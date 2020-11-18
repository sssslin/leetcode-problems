package com.tags.stack.preorderTraversal;

import test.BaseSolution;
import test.TreeNode;

import java.util.ArrayList;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        // result唯一的职责就是存放最后的结果
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // curr作为一个指针，它指向的结点，就是下一个需要放入result的值
        TreeNode curr = root;
        //
        Stack<TreeNode> stack = new Stack<>();

        stack.push(curr);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            // 因为stack是先进后出的，所以这里要将右节点压入栈中
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
        return result;
    }

}
