package com.tags.binarysearch.search;

//给你一个整数数组 nums ，和一个整数 target 。
// 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
// ）。
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
// 示例 1：
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 示例 2：
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
// 示例 3：
//输入：nums = [1], target = 0
//输出：-1
// 提示：
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// nums 肯定会在某个点上旋转
// -10^4 <= target <= 10^4
// Related Topics 数组 二分查找

/**
 * 这个题目，我原来的写法是，寻找旋转点，但是看了题解之后发现，正确的做法不是寻找旋转点
 *
 */
// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/er-fen-cha-zhao-tu-jie-miao-dong-by-struggle_he/
class Solution {
    // 错误做法：寻找旋转点
    public static int search(int[] nums, int target) {
        // corner case
        if (nums.length == 1 && nums[0] != target) return -1;
        // 寻找旋转的点
        int roastIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                roastIndex = i;
                break;
            }
        }
        int mid = 0;
        // 分为两个数组进行二分[0,roastIndex], [roastIndex + 1, nums.length-1]
        int minLeft = roastIndex + 1, minRight = nums.length - 1;
        while (minLeft < minRight) {
            mid = (minLeft + minRight) / 2;
            if (nums[mid] < target) {
                minLeft = mid + 1;
            } else {
                minRight = mid;
            }
        }

        if (nums[mid] == target) return mid;

        int maxLeft = 0, maxRight = roastIndex;
        while (maxLeft < maxRight) {
            mid = (maxLeft + maxRight) / 2;
            if (nums[mid] < target) {
                maxLeft = mid + 1;
            } else {
                maxRight = mid;
            }
        }
        if (nums[mid] == target) return mid;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int index = search1(nums, 3);
        System.out.println(index);
    }


    public static int search1(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        // 这种写法是left < right的
        // https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/er-fen-fa-python-dai-ma-java-dai-ma-by-liweiwei141/
        while (left < right) {// 边界：为什么这里需要是left <= right
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {// 如果nums[mid] < nums[right],则说明旋转点在左侧，即右侧有序
                if (nums[mid] < target && target <= nums[right]) { // target在右侧有序的区间
                    left = mid + 1;
                } else { // 在左侧无序区间
                    right = mid - 1;
                }
            } else { // 如果nums[mid] > nums[right],则说明旋转点在右侧，即左侧有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
        }
        return -1;
    }
}
