package com.tags.array.containsNearbyAlmostDuplicate;

import java.util.TreeSet;

/**
 * 条件1：abs(nums[i] - nums[j]) <= t 最终可以转换成以下的格式
 * nums[i]−nums[j]<=t （不等式 1）
 * 并且
 * nums[i] - nums[j] >= -tnums[i]−nums[j]>=−t （不等式 2）。
 *
 * 问题遗留，为什么要用long
 *
 */
class Solution {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // floor函数返回小于等于给定元素的最大元素
            // ceiling函数返回大于等于给定元素的最小元素

            Long floor = set.floor((long) nums[i]);
            Long ceil = set.ceiling((long) nums[i]);
            if (ceil != null && (long) nums[i] - floor <= t) return true;
            if (ceil != null && ceil - (long) nums[i] <= t) return true;

            // 添加后，控制查找表（窗口）大小，移除窗口最左边元素
            set.add((long) nums[i]);
            set.forEach(e -> System.out.print(e + " "));
            System.out.println();
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3, t = 0;

        boolean flag = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(flag);
    }
}

