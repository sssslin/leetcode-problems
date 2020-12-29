package com.tags.binarysearch.template;

/**
 * 这种写法，是最基本的写法，直接往中间切一份，则数组被划分为[left, mid - 1], mid, [mid + 1, right]
 */
public class Solution {

    public static int search(int[] nums, int target) {
        // 特殊用例判断
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        // 在 [left, right] 区间里查找 target
        int left = 0;
        int right = len - 1;
        while (left <= right) {// 这种写法的话，跳出循环的条件是left > right, 即[right, left],原本的left与right的位置关系相反了
            // 为了防止 left + right 整形溢出，写成如下形式
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // 下一轮搜索区间：[left, mid - 1]
                right = mid - 1;
            } else {
                // 此时：nums[mid] < target，下一轮搜索区间：[mid + 1, right]
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1 , 9 , 10 , 200 ,1000, 9999};
        int target = 2;
        int index = search(nums, target);
        System.out.println(index);
    }
}
