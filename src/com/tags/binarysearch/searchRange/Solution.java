package com.tags.binarysearch.searchRange;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
// 如果数组中不存在目标值 target，返回 [-1, -1]。
// 进阶：
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
// 示例 1：
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
// 示例 2：
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
// 示例 3：
//输入：nums = [], target = 0
//输出：[-1,-1]
// 提示：
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums 是一个非递减数组
// -109 <= target <= 109
// Related Topics 数组 二分查找
// 👍 786 👎 0
public class Solution {
    // 本题的解法是，先通过二分向上取整的方法，得到target的右边界，然后往前查找。
    // 但是正确的做法应该是，左边界通过二分向下取整的方法获取，右边界通过二分向上取整的方法获取
    public static int[] searchRange(int[] nums, int target) {
        int[] resultArray = {-1, -1};
        if (nums == null || nums.length == 0) return resultArray;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (nums[right] != target) {
            return resultArray;
        } else {
            resultArray[0] = right;
            resultArray[1] = right;
            int startIndex = right;
            int endIndex = right;
            for (int i = endIndex; i > 0; i--) {
                if (nums[i - 1] != nums[right]) {
                    break;
                }
                startIndex--;
            }
            resultArray[0] = startIndex;
            return resultArray;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 10};
        int target = 6;
        int[] resultArray = searchRange(nums, target);
        System.out.println(resultArray[0]);
        System.out.println(resultArray[1]);
    }
}
