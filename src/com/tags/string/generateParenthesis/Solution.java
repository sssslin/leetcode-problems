package com.tags.string.generateParenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",完全嵌套
//       "(()())", 一大嵌套2小
//       "(())()",左嵌套 右不嵌套
//       "()(())",左不嵌套 右嵌套
//       "()()()"完全不嵌套
//     ]

/**
 * 这是一道回溯（DFS）的题目，突然在看了题解之后发现自己对递归表达式完成计算后，进行回归计算时，
 * 对于为何会返回结果非常的疑惑。在左程云的视频里，我记得递归的本质是，出栈后计算结果完成后再次入栈，
 * 回归计算，就相当于再次入栈的操作。
 * 抽空学习：左程云的基础入门视频
 */
class Solution {
    public static List<String> generateParenthesis(int n) {
        // 用来存放所有符合要求的括号字符串
        List<String> res = new ArrayList<>();

        helper("", res, n, 0, 0);
        return res;
    }

    /**
     *
     * @param curr 当前string状态
     * @param res 记录结果的集合
     * @param n 总的括号数
     * @param left 已有的左括号
     * @param right 已有的有括号
     */
    private static void helper(String curr, List<String> res, int n, int left, int right) {
        // base case
        if (right == n) {
            res.add(curr);
            return;
        }

        // 左括号没用完的时候可以一直递归，进行深度遍历
        if (left < n) {
            helper(curr + "(", res, n, left + 1, right);
        }

        if (right < left) {
            helper(curr + ")", res, n, left, right + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParenthesis(n);
        System.out.println(res.toString());
    }
}

