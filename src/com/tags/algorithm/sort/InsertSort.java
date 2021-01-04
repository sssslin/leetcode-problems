package com.tags.algorithm.sort;

/**
 * 插入排序的代码实现虽然没有冒泡排序和选择排序那么简单粗暴，但它的原理应该是最容易理解的了，
 * 因为只要打过扑克牌的人都应该能够秒懂。插入排序是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 插入排序和冒泡排序一样，也有一种优化算法，叫做拆半插入。
 */
public class InsertSort {
    public static void main(String[] args) {
        int nums1[] = new int[]{10, 5, 2, 6};
        int n = nums1.length;

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < nums1.length; i++) {

            // 记录要插入的数据, i是未排序的数的下标
            int need = nums1[i];

            // 从已经排序的序列最右边排好序第一个的开始比较，找到比其小的数
            int j = i - 1;
            while (j >= 0 && need < nums1[j]) {
                nums1[j + 1] = nums1[j];
                j--;
            }

            // 插入
            if (j != i - 1) {
                nums1[j + 1] = need;
            }
        }

    }
}
