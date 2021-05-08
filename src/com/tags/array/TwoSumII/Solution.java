package com.tags.array.TwoSumII;

import java.util.Arrays;

/**
 * 数组的表示长度：length
 * 字符串表示长度：length()
 *
 *
 */
public class Solution {
    public static int[] twoSum(int[] numbers, int target) {

        int[] sum = {0, 0};

        String s = "";
        s.length();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target){
                    sum[0] = i + 1;
                    sum[1] = j + 1;
                    return sum;
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 3,4};
        int[] result = twoSum(nums, 0);
        System.out.println(Arrays.toString(result));
    }
}
