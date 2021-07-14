package com.tags.algorithm.backtracking.combinationSum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 回溯算法练习
 *
 * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 */
public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     *
     * @param candidates 给定元素的集合数组
     * @param begin 遍历的起始点
     * @param len
     * @param target 给定的目标值，每减去一个元素，目标值越小
     * @param path 从根节点到叶子节点的路径，是一个栈
     * @param res 结果集列表
     */
    public static void dfs(int[] candidates, int begin, int len, int target,Deque<Integer> path, List<List<Integer>> res) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            dfs(candidates, i, len, target - candidates[i], path, res);

            path.removeLast();
            System.out.println("递归之后 => " + path);

        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
}
