package com.tags.array.duplicates;

import java.util.Arrays;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length < 2) return nums.length;

        // slow代表当前需要校验的值，当完成整个循环的时候，表示最终数组中有多少个数字符合条件
        // fast作为一个标志，当存在重复两次的时候，fast值替代slow的值
        int slow = 2;
        for(int fast = 2; fast < nums.length; fast++) {
            // 进入这个循环表示，之前的循环中存在重复两次的数值，当找到合法数值时，需要将合法数值放置到slow的位置，slow++
            if(!(nums[slow - 1] == nums[fast] && nums[slow - 2] == nums[fast])) {
                nums[slow] = nums[fast];
                slow++;
                System.out.println(Arrays.toString(nums ));
            }
        }
        // slow 代表数组里有效的元素数量
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 3};
        int length = removeDuplicates(nums);
        System.out.println(length);
    }
}
