package com.tags.array.sortColors;

import java.util.Arrays;
/*
   时间复杂度 : O(n) 空间复杂度: O(1)
   在这道题目中，j代表的是当前的指针，
   i，j,k三个变量的意义在于，将数组分割成4个区域
   [0,i)：包含所有a
   [i,j): 包含所有b
   [j,k]：未排序元素
   (k,len - 1]:包含所有c
   在j指针的移动过程中，交换元素的位置，使元素一直保持以上这个分割区间，
   直到j与k相遇，则表明所有元素，排序完毕
 */
public class Solution {

    // https://www.youtube.com/watch?v=yTwW8WiGrKw
    public static void sortColors(int[] nums) {
        // corner case
        if(nums == null || nums.length <= 1) {
            return;
        }

        // init
        int i = 0, j = 0, k = nums.length - 1;

        while(j <= k) {
            if(nums[j] == 0) {
                swap(nums, i++, j++);
            }
            else if(nums[j] == 0) {
                j++;
            }
            else{
                // nums[j] = 2
                swap(nums, j, k--);
            }
        }
    }

    public static void swap(int[] nums, int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}