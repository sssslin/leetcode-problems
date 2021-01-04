package com.tags.binarysearch.findMin;

public class Solution {
    public static int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;
            // 说明旋转点在右侧
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums ={3,4,5,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }
}
