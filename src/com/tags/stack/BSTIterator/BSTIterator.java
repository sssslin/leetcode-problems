package com.tags.stack.BSTIterator;

import test.TreeNode;

import java.util.Stack;

public class BSTIterator {

    // 这里犯了一个比较严重的错误，一般来说，用stack做树的题目，存的肯定是TreeNode而不是节点值
    private Stack<TreeNode> stack = new Stack<>();

    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    /**
     * @return the next smallest number
     */
    // 使用的是非递归中序遍历。中文版和英文版的区别在于，英文版中要求的是平均时间复杂度为O(1)
    // 均摊时间复杂度是什么意思？需要好好找时间解决这个基础概念问题
    // 平均是O(1), 因为平均下来每个节点push一次，pop一次

    /**
     *之前一直以为每次调用next()方法都会完整的遍历一遍一刻完整的树，
     * 但是其实不是的，每次遍历后将保存下一次的起始节点。
     * 当一个节点有左子树的时候才会进入循环。
     * 虽然有时候一个节点需要多次遍历才能获取到，单独操作的代价很高。但是从整体上来看，
     * 由于push、pop的成对存在，总的遍历时间代价为O(n),总共花费n次。
     * 所以均摊的代价为O(1).
     * 其实这是一种叫摊还分析的方法。具体内容见算法导论第17章。其中就以栈为例，分析了
     * 为什么一个新的栈操作的平均代价为O(1)
     */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    /**
     * @return whether we have a next smallest number
     */
    /**
     *
     * @return
     */
    public boolean hasNext() {
        // 思路没有问题，但是用size是否等于的方式判断不够严谨
//        boolean flag = stack.size() == 0 ? false : true;
//        return flag;

        if (!stack.isEmpty() || cur != null) return true;
        else                                 return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        int res1 = iterator.next();    // 返回 3
        System.out.println(res1);

        int res2 = iterator.next();    // 返回 7
        System.out.println(res2);

        boolean flag1 = iterator.hasNext(); // 返回 true
        System.out.println(flag1);

        int res3 = iterator.next();    // 返回 9
        System.out.println(res3);

        boolean flag2 = iterator.hasNext(); // 返回 true
        System.out.println(flag2);

        int res4 = iterator.next();    // 返回 15
        System.out.println(res4);

        boolean flag3 = iterator.hasNext(); // 返回 true
        System.out.println(flag3);

        int res5 = iterator.next();    // 返回 20
        System.out.println(res5);

        boolean flag4 = iterator.hasNext(); // 返回 false
        System.out.println(flag4);

    }
}
