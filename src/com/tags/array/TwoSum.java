package com.tags.array;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] resultArray = twoSum(nums, target);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i]);
        }
    }

    // 个人第一次的写法,用的是最简单的遍历
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == (target - nums[i]) ) {
                    int twoSumArray[] = {j, i};
                    return twoSumArray;
                }
            }
        }
        return null;
    }
}
