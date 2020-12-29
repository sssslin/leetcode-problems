package com.tags.binarysearch.search2;

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
//
// 示例 1:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
//
//
// 示例 2:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false
//
// 进阶:
//
//
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
//
public class Solution {
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                // 这里必须是小于号，上次比较时，已经比较了 target <= nums[mid]的可能，这里再次比较时，就只剩下target > nums[mid]的可能性了
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] == target) {
                    return true;
                } else {
                    left = left + 1;
                }
            }
        }

        // 需要进行后置处理，判断目标值是否存在于数组中
        return target == nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        boolean flag = search(nums, 0);
        System.out.println(flag);
    }
}
