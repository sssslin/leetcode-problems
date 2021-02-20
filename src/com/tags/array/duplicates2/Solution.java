package com.tags.array.duplicates2;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int slow = 1, fast = 1;
        for (; fast < nums.length; fast++) {
            if (!(nums[fast] == nums[slow - 1])) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
