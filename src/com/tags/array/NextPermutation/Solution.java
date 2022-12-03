package com.tags.array.NextPermutation;

import java.util.Arrays;

/**
 * 题意理解：Permutation
 *
 * 这个题属于完全不会的，连理解题意都存在困难，之后要多次琢磨
 *
 * 首先，说明一下题意，要做这个题，就要知道Permutation的意思，即全排列
 * 即将一组数，按照字典顺序，一次排列起来，更直白的说法就是，一组数连起来比之前大，
 * 但是在所有的更大的中，是最小的，一次类推，本题的题意就是，给你一组数据，
 * 写出全排列中，下一个比当前数组大的排序（在所有最大的中最小）
 * 如果是最大的，那么，返回最小的排序数组
 *
 * 
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {1, 5, 7, 9, 8, 2, 1};
        nextPermutation(nums);
    }

    // 复杂度---time:O(n), space:O(1)
    public static void nextPermutation(int[] nums) {

      if (nums == null || nums.length == 0) return;

      int fast = nums.length - 2;
      while (fast >= 0 && nums[fast + 1] <= nums[fast]) {
          fast--;
      }

      if (fast >= 0) {
          int slow = nums.length - 1;
          while (slow >= 0 && nums[slow] <= nums[fast]) {
              slow--;
          }
          swap(nums, slow, fast);
      }
      reverse(nums, fast + 1, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private static void swap(int[] nums, int slow, int fast) {
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = nums[slow];
    }

}
