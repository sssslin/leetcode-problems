package com.tags.array.duplicates;

public class Solution {
    /***
     * slow 指针表示下一个数字要填填入的下表位置
     * fast 指针表示遍历到的数组的具体位置
     * 当fast指针遍历完整个数组之后，结束
     * @param nums
     * @return int
     * @date 2022/5/8 14:40
     * @author linjunfeng
     */
    public static int removeDuplicates(int[] nums) {
     // init
     int slow = 0, fast = 1;
     while(fast < nums.length) {
         if (nums[slow] != nums[fast]) {
             slow++;
             nums[slow] = nums[fast];
         }

         fast++;
     }

     return slow + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 3};
        int length = removeDuplicates(nums);
        System.out.println(length);
    }
}
