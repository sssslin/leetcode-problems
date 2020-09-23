package com.tags.array;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {

        int nums[] = {3, 2, 2, 3};// 3
        //int nums[] = {0, 1, 2, 2, 3, 0, 4, 2};
        int length = removeElement(nums, 3);
        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * time:O(n), space:O(1)
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);

        int count = 0;
        int len = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                count++;
            } else {
                if (nums[len] != val) {
                    nums[i] = nums[len];
                    len--;
                }
            }
        }
        return count;
    }
}
