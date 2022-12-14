package com.tags.array.TwoSumII;

import java.util.Arrays;

/**
 * 数组的表示长度：length
 * 字符串表示长度：length()
 */
public class Solution {

    // brute force
    public static int[] twoSum(int[] numbers, int target) {

        int[] sum = {0, 0};

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    sum[0] = i + 1;
                    sum[1] = j + 1;
                    return sum;
                }
            }
        }

        return sum;

    }

    // two pointer
    public static int[] twoSumTwoPointer(int[] numbers, int target) {

            int left = 0;
            int right = numbers.length - 1;

            while(left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum < target) {
                    left++;
                } else if (sum == target) {
                    int[] result ={left + 1, right + 1};
                    return result;
                } else if (sum > target) {
                    right--;
                }
            }
            int[] result ={ -1, -1};
            return result;
    }

    // acwing模板
    public static int[] twoSumAcwing(int[] numbers, int target) {

        int[] result = new int[]{-1, -1};
        for (int left = 0, right = numbers.length - 1; left < right; left++) {

            while (numbers[left] + numbers[right] > target) right--;

            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 3, 4};
        int[] result = twoSum(nums, 0);
        int[] result1 = twoSumTwoPointer(nums, 0);
        int[] result2 = twoSumAcwing(nums, 0);
      //  System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
      //  System.out.println(Arrays.toString(result2));
    }
}
