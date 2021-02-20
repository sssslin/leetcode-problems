package com.tags.array.merge;

import java.util.Arrays;

public class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;

        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
            int temp = len + 1;
            System.out.println(nums1[temp]);
        }
        // len + 1的意义在于len2移动之后要变成数组2复制到数组1之后要往前移动一位
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
    }

}
