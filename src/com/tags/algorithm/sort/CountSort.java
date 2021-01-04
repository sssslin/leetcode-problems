package com.tags.algorithm.sort;

public class CountSort {
    public static void main(String[] args) {
        int nums1[] = new int[]{10, 5, 2, 6, 0};
        // 假设对<=100的数字进行排序
        int[] cnt = new int[101];
        for (int i = 0; i < nums1.length; i++) {
            cnt[nums1[i]]++;
        }

        int k = 0;
        for (int v = 0; v < 101; v++) {
            while (cnt[v] > 0) {
                nums1[k++] = v;
                cnt[v]--;
            }
        }

    }
}
