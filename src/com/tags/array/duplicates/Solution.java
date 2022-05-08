package com.tags.array.duplicates;


public class Solution {
    public static int removeDuplicates(int[] nums) {
     // init
     int slow = 0, fast = 1;
     while(fast < nums.length) {
         if (nums[slow] == nums[fast]) {
             fast++;
         }

         if (nums[slow] < nums[fast]) {
             nums[slow + 1] = nums[fast];
             slow++;
             fast++;
         }
     }

     return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 3};
        int length = removeDuplicates(nums);
        System.out.println(length);
    }
}
