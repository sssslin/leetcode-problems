package com.tags.binarysearch.findDuplicate;

/**
 * @author junfeng.ling
 * @date 2020/12/28 20:52
 * @Description:
 */
public class Solution {
    public static int findDuplicate(int[] nums) {
        int length = nums.length;
        // 本题采用的是抽屉原理，左边界为1,右边界则是n
        int left = 1;
        int right = length - 1;

        while(left < right) {
            // 求中位数
            int mid = left + (right - left) / 2;

            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] <= mid) {
                    count++;
                }
            }

            if(count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        // 由于是采用的是left < right,所以返回left或者right都一样
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        int duplicateNum = findDuplicate(nums);
        System.out.println(duplicateNum);
    }
}
