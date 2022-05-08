package com.tags.array.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: linjunfeng
 * @Title: FourSum
 * @Description:
 * @date: 2022/4/24 07:45
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length < 4 && nums == null) return new ArrayList<>();
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right  && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    if (sum < target) left++;
                    if (sum > target) right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5};
        int target = -13;
        List<List<Integer>> lists = fourSum(nums, target);

        System.out.println(Arrays.toString(lists.toArray()));
    }

}
