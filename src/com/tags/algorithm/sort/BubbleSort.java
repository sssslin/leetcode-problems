package com.tags.algorithm.sort;

// https://www.acwing.com/file_system/file/content/whole/index/content/1166906/

import java.util.Arrays;

/**每次相邻两个数字进行比较，将大的数字交换到后一个，然后继续操作，一直把本趟最大数字放在最后，
 * 完成了一趟，接着对前n-1个数字进行相同的交换操作，将次大的数字放在倒数第二位的位置，一直到所有数字都排列好。
 * time:O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int nums1[] = new int[]{4, 1, 3, 1, 5, 2};
        bubbleSort(nums1, nums1.length);
    }


    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    System.out.println(Arrays.toString(a));
                }
            }
        }
    }
}
