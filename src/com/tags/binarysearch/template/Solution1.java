package com.tags.binarysearch.template;

import static com.template.binarySearch.integer.Template.check;

public class Solution1 {
    public int search(int[] nums, int left, int right, int target) {
        // 在区间 [left, right] 里查找目标元素
        while (left < right) {
            // 选择中间数时下取整
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        // 退出循环的时候，程序只剩下一个元素没有看到，视情况，是否需要单独判断 left（或者 right）这个下标的元素是否符合题意
        // 后置处理
        return -1;
    }


}
