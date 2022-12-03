package com.tags.array.RemoveElement;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        // int nums[] = {3, 2, 2, 3};// 3
        int nums[] = {0, 1, 2, 2, 3, 0, 4, 2};
        int length = removeElement(nums, 3);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * time:O(n), space:O(1)
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {

        // 区间 [0, left) 内的元素都不等于 val
        // 区间 [left, right] 内的元素为待处理元素
        // 区间 (right, n) 的长度等于值为val的长度
        if (nums == null || nums.length == 0) return 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                // 将 right 位置的待处理元素放到 left 位置
                nums[left] = nums[right];
                right--;
            } else {
                // 扩大不等于val的元素区间
                left++;
            }
        }
        return left;
    }

    public static int removeElement1(int[] nums, int val) {
        // 区间 [0, left) 内的元素都不等于 val
        // 区间 [right, n) 内的元素为待处理元素
        // 区间 [left, right) 内的元素都等于 val
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                // 将 nums[right] 追加至保留元素列表的末尾
                nums[left++] = nums[right];
            }
            ++right;
        }
        // 返回不等于val的元素的长度
        return left;
    }
}
