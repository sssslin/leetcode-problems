package com.tags.array;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

    }


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.EMPTY_LIST;
        }

        // sort
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int right = nums.length - 1;
            // second loop to judge sum of three numbers
            for (int left = i + 1; left < nums.length; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1]) continue;
                while (left < right && nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
                if (left == right) break;
                if (nums[i] + nums[left] + nums[right] == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
            }
        }
        return list;


    }
}
