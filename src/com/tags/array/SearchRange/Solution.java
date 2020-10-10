package com.tags.array.SearchRange;

import java.util.Arrays;

/**
 * space:O(1)
 * time:O(logn)
 *
 * 二分查找
 */
public class Solution {

    public static void main(String[] args) {

        int nums[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        int result[] = {-1, -1};

        if (nums == null || nums.length == 0) return result;

        int first = findFirst(nums, target);
        if (first == -1) return result;
        int last = findLast(nums, target);

        result[0] = first;
        result[1] = last;
        return result;
    }

    private static int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    private static int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }
}
