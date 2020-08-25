package com.tags.array;

import java.util.HashMap;

/**
 * 优化思路:空间换时间
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        long startTime = System.nanoTime();
        int[] resultArray = twoSum(nums, target);
        System.out.println(System.nanoTime() - startTime);

        long startTime2 = System.nanoTime();
        int[] resultArray2 = twoSum2(nums, target);
        System.out.println(System.nanoTime() - startTime2);

        long startTime3 = System.nanoTime();
        int[] resultArray3 = twoSum3(nums, target);
        System.out.println(System.nanoTime() - startTime3);

//        for (int i = 0; i < resultArray.length; i++) {
//            System.out.println(resultArray[i]);
//        }


    }

    // 个人第一次的写法,用的是最简单的遍历,两层的for循环,时间复杂度为O(n^2)
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
}
