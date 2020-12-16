package com.tags.array.FourSum;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int nums[] = {0, 0, 0, 0};
        List<List<Integer>> result = fourSum(nums, 0);
        for (List<Integer> e : result) {
            System.out.println(Arrays.toString(e.toArray()));

        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;// 去重
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;// 去重
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int result = nums[i] + nums[j] + nums[left] + nums[right];
                    if (result == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 提交的时候，把这里写成continue了，得注意
                        while (left < right && nums[left] == nums[left + 1]) left++;// 去重，left逐渐变大，所以要加1
                        while (left < right && nums[right] == nums[right - 1]) right--;// 去重，right逐渐变小，所以要减1
                        // 找到满足条件的数字,然后还需要继续寻找其他和为target可能的方案，所以需要继续向中间寻找
                        // 单独移动指针是肯定不可能符合要求的
                        // 比如 [1,2,3,4],1和4之和等于target,单独移动指针肯定是过大或者过小，所以要一起移动指针
                        left++;
                        right--;
                    }
                    else if (result < target) left++;
                    else right--;

                }
            }
        }
        return res;
    }
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        return kSum(nums, target, 0, 4);
//    }

//    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
//            return res;
//        if (k == 2)
//            return twoSum(nums, target, start);
//        for (int i = start; i < nums.length; ++i)
//            if (i == start || nums[i - 1] != nums[i])
//                for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
//                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
//                    res.get(res.size() - 1).addAll(set);
//                }
//        return res;
//    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }
}
