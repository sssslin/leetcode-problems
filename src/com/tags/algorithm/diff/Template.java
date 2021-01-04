package com.tags.algorithm.diff;

public class Template {
    public static void main(String[] args) {
        int[] nums = {};
        int[] diff = new int[nums.length];
        // 构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        /**
         * 如果对指定区间内nums[i,j]加一个数val，则
         * diff[i] + val, diff[j + 1] - val即可
         */
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }

    }
}
