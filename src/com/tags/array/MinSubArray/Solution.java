package com.tags.array.MinSubArray;


import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        int target = 213;

        int len = minSubArrayLen(target, nums);
        System.out.println(len);
    }

    /**
     * 该题使用双指针---滑动窗口解决
     * <p>
     * 题意分析：
     * 这道题的核心在于
     * 1、连续子数组
     * 2、连续子数组的和要 >= target
     * 3、这个连续子数组的长度要在所有可能的解中是最小的
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        // corner case
        int length = nums.length;
        if(length == 0) return 0;

        // 初始化左右端点
        int left = 0, right = 0;

        int result = Integer.MAX_VALUE;
        int sum = 0;
        while(right < length) {
            // 右端点一直向右移动，代表寻找可行解：外层循环寻找可行解
            sum += nums[right];
            while(sum >= target) {
                // 内层循环寻找最优解
                result = Math.min(result, right - left + 1);
                sum -= nums[left];

                System.out.print(String.format("当前左端点位置：%s， 左端点值：%s.", left, nums[left]));
                System.out.print(" ");
                System.out.println(String.format("当前右端点位置：%s， 右端点值：%s.", right, nums[right]));

                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
