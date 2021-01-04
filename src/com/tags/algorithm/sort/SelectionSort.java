package com.tags.algorithm.sort;

/**
 * 首先通过n-1次比较，从n个数字中找到最小的数，将它和第一个数字交换—第一趟选则排序，结果最小的被安置在第一个位置。
 * 再通过n-2次比较，从剩余的n-1个数字找到次小的数，将它与第二个数交换—第二趟选则排序，结果次小的被安置在第二个位置。
 * 重复上述过程......
 * 通过n-1趟排序后完成。
 */
public class SelectionSort {

    public static void main(String[] args) {
        int nums1[] = new int[]{10, 5, 2, 6};
        int n = nums1.length;

        int i, j, t, k = 0;
        for (i = 0; i < n - 1; i++) {       // N个数字需要N-1趟排序
            k = i;                          // 本趟排序的N-i个数的第一个数下标为i，k是本趟要找的最小数字的下标
            for (j = i + 1; j < n; j++) {
                if (nums1[k] > nums1[j]) {
                    k = j;
                }
            }
            t = nums1[k];                   // 将找到到的最小元素放在最前面
            nums1[k] = nums1[i];
            nums1[i] = t;
        }
    }
}
