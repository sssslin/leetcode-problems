package com.tags.algorithm.backtracking.permuteUnique;

import java.util.*;

/**
 * 学习或者说刷题，关注点应该在于思路和学习的过程，而不是抄答案，抄完就算会的做法是毫无收益可言的
 */
public class Solution {
    public static List<List<Integer>> permuteUnique(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        // 排序，为了剪枝方便
        Arrays.sort(nums);
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, res);

        return res;
    }

    private static void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {

        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证nums[i - 1]有意义
            // 写!used[i - 1] 是因为nums[i - 1]在深度优先遍历中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, path, res);
            // 回溯部分的代码，和dfs之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] arrays = {3, 3, 0, 3};

        List<List<Integer>> lists = permuteUnique(arrays);
        System.out.println(lists);
    }
}
