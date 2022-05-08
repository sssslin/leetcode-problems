package com.tags.array.ThreeSumClosest;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int nums[] = {-1, 2, 1, -4};
        int result = threeSumClosest1(nums, 1);
        System.out.println(result);
    }


    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        // nums.length - 2是为了保证 left 永远小于right,且数组下标不越界，因为边界就是nums.length - 2
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left != right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;

                if (sum > target) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return result;
    }

    public static int threeSumClosest1(int[] nums, int target) {

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - result) > Math.abs(target - sum)) result = sum;
                if (sum > target) right--;
                if (sum < target) left++;
                if (sum == target) return sum;
            }
        }

        return result;
    }
}
