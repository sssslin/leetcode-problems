package com.tags.array.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 优化思路:空间换时间
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        long startTime = System.nanoTime();
        int[] resultArray = twoSum(nums, target);
        System.out.println(Arrays.toString(resultArray));
        System.out.println(System.nanoTime() - startTime);

        long startTime2 = System.nanoTime();
        int[] resultArray2 = twoSum2(nums, target);
        System.out.println(System.nanoTime() - startTime2);

        long startTime3 = System.nanoTime();
        int[] resultArray3 = twoSum3(nums, target);
        System.out.println(System.nanoTime() - startTime3);
        System.out.println();
    }

    // 个人第一次的写法,用的是最简单的遍历,两层的for循环,时间复杂度为O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (target == nums[i] + nums[j]) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }

    // 将两个for循环拆开,复杂度为O(n),通过HashMap常数级的查找效率降低复杂度
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            m.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int t = target - nums[i];
            if (m.containsKey(t) && m.get(t) != i) {
                res[0] = i;
                res[1] = m.get(t);
                break;
            }
        }
        return res;
    }

    public static int[] twoSum3(int[] nums, int target) {
        // 这个解法的关键在于用了hashmap
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
            // 与平时的方法不同,通过元素值反过来找索引
            m.put(nums[i], i);
        }
        return res;
    }

    public static int[] twoSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // key 数组的值  value 数组的索引
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
           if (map.containsKey(target - nums[i])) {
               return new int[] {map.get(target - nums[i]), i};
           }
            map.put(nums[i], i);
        }
        return null;
    }
}
