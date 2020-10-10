package com.tags.array.SearchInsert;

/**
 * space:O(1)
 * time:O(logn)
 */
public class Solution {

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        int index = searchInsert(nums, 4);
        System.out.println(index);
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        if (nums == null || nums.length == 0) return 0;

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (target <= nums[start]) return start;
        if (target > nums[start] && target < nums[end]) return start + 1;
        if (target == nums[end]) return end;
        if (target > nums[end]) return end + 1;

        return index;
    }

}
