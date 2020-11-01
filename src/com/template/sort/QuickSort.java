package com.template.sort;

public class QuickSort {
    public static void main(String[] args) {
        int nums1[] = new int[] {10, 5, 2, 6, 0};
        quickSort(nums1, 0, nums1.length - 1);
    }

    public static void quickSort(int[] a, int l, int r) {
        if (l >= r) {
            // 不需要操作
            return;
        }
        // 分割点可以选第一个数字，可以选第二个数字，也可以random一个a数组的数字，也可以使用median three选一个
        int pivot = a[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (pivot > a[i]);

            do {
                j--;
            } while (pivot < a[j]);

            // 指针没有相遇
            if (i < j) {
                swap(a, i, j);
            }
        }

        quickSort(a, l, j);
        quickSort(a, j + 1, r);
    }

    private static void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }
}
