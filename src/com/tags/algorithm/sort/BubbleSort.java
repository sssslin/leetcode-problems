package com.tags.algorithm.sort;

// https://www.acwing.com/file_system/file/content/whole/index/content/1166906/
/**每次相邻两个数字进行比较，将大的数字交换到后一个，然后继续操作，一直把本趟最大数字放在最后，
 * 完成了一趟，接着对前n-1个数字进行相同的交换操作，将次大的数字放在倒数第二位的位置，一直到所有数字都排列好。
 * time:O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int nums1[] = new int[]{10, 5, 2, 6};
        int n = nums1.length;
        for (int i = 0; i < n - 1; i++) {           // N个数字，N-1趟排序
            for (int j = 0; j < n - 1 - i; j++) {   // 每趟需要N-1-i次比较/交换
                int t = nums1[j];
                nums1[j] = nums1[j + 1];
                nums1[j + 1] = t;
            }
        }
    }
}
