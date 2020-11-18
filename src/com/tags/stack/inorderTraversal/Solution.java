package com.tags.stack.inorderTraversal;

import test.BaseSolution;
import test.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
// 示例 1：
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 示例 2：
//输入：root = []
//输出：[]
// 示例 3：
//输入：root = [1]
//输出：[1]
// 示例 4：
//输入：root = [1,2]
//输出：[2,1]
// 示例 5：
//输入：root = [1,null,2]
//输出：[1,2]
// 提示：
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表
// 👍 773 👎 0
public class Solution extends BaseSolution {
    // 第一版，自己完成，完全没有优化过的版本
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        results = helper(results, nodeStack);

        return results;
    }

    public List<Integer> helper(List<Integer> results, Stack<TreeNode> nodeStack) {
        if (!nodeStack.isEmpty()) {
            TreeNode root = nodeStack.pop();
            // 虽然是通过栈实现，但是仍然是换汤不换药，所谓的中序，也就是：左-根-右
            // 所以以下代码的顺序就是 先处理左子树，然后再处理根节点，最后再处理右节点
            // 其他的遍历方式，可以参考这个模板，交换顺序即可
            if (root.left != null) {
                nodeStack.push(root.left);
                helper(results, nodeStack);
            }

            results.add(root.val);

            if (root.right != null) {
                nodeStack.push(root.right);
                helper(results, nodeStack);
            }
        }
        return results;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        // 通过循环 + 指针引用的方式起到了和递归同样的作用
        while (curr != null || !stack.isEmpty()) {
            // 将所有的左节点都存到stack中
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            results.add(curr.val);
            curr = curr.right;
        }

        return results;
    }

}
