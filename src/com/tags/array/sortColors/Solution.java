package com.tags.array.sortColors;

import java.util.Arrays;

/*
   时间复杂度 : O(n) 空间复杂度: O(1)
 */
public class Solution {

    /**
     * 解题思路
     * 原题为荷兰国旗问题，根据《算法导论》中提到的  循环不变量 性质分割对应的区间
     * [0, P0) == 0
     * [P0, i) == 1
     * [P1, len - 1] == 2
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        // corner case
        if (nums == null || nums.length <= 1) {
            return;
        }

        int p0 = 0;
        int i = 0;
        int p2 = nums.length - 1;
        while (i <= p2) {
            if (nums[i] == 0) {
                // p0++，保证[0. p0)之间的值都是为0
                swap(nums, i++, p0++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                // p2--，保证数组的末尾都是为2
                swap(nums, i, p2--);
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}