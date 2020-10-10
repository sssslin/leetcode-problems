package com.tags.array.NextPermutation;

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

    }

    // 复杂度---time:O(n), space:O(1)
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int n = nums.length;
        int i = n - 2;
        // 从后往前找，后半段如果是升序的，继续往前，如果出现升序的情况，则开始进行数据交换
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果进入这个if语句，则说明肯定存在下一个全排序
        if (i >= 0) {
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 完全降序排列也是适用的
        reverse(nums, i + 1, n - 1);
    }

    // 交换
    public static void swap(int[] nums, int  lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

    // 反转
    private static void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }
}
