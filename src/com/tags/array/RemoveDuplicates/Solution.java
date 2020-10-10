package com.tags.array.RemoveDuplicates;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int nums[] = {1, 1, 2};
        int count = removeDuplicates(nums);

        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }


    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int count = 1;// 第一个指针，用来表示不重复的数字的数量，符合要求时+1
        // 做法就是给将不重复的数替换掉原来重复的数字的位置
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                // 替换掉在该位置上，重复的数字
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
