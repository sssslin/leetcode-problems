package com.tags.array.MaxArea;

/**
 * Leetcode 第十一题
 */
public class Solution {

    public static void main(String[] args) {

        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int max = maxArea(test);
        System.out.println(max);
    }


    /***
     * @param height
     * @return int
     * @date 2022/4/10 4:38 PM
     * @author linjunfeng
     * 双指针算法，左右指针相向而行
     */
    public static int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }

        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {

            int length = right - left;
            int high = height[left] < height[right] ? height[left] : height[right];

            // 判断左右指针的高度，只移动当前指针所在点位高度较小的那个
            if (height[right] > height[left]) {
                maxArea = maxArea > length * high ? maxArea : length * high;
                left++;
            } else {
                maxArea = maxArea > length * high ? maxArea : length * high;
                right--;
            }

            System.out.print(length);
            System.out.print("     ");
            System.out.print(high);
            System.out.print("     ");
            System.out.println(maxArea);

        }

        return maxArea;
    }
}
