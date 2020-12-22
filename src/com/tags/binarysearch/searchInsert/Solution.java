package com.tags.binarysearch.searchInsert;

import java.util.Arrays;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
// 你可以假设数组中无重复元素。
// 示例 1:
// 输入: [1,3,5,6], 5
//输出: 2
// 示例 2:
// 输入: [1,3,5,6], 2
//输出: 1
// 示例 3:
// 输入: [1,3,5,6], 7
//输出: 4
// 示例 4:
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
// 👍 765 👎 0
public class Solution {
    /**
     * 这种二分写法：进行二分切割之后，区间就分为[left, mid]、[mid + 1, right],即mid被划分到了左边
     */
    public static int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return 0;
        if (nums[nums.length - 1] < target) return nums.length;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;

        int result = search(nums, target);
        System.out.println(result);
    }
}
