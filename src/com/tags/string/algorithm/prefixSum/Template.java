package com.tags.string.algorithm.prefixSum;

public class Template {
    public static void main(String[] args) {
        // 由于 nums 全都是正整数，因此 preSum 严格单调增加
        // preSum 表示 sum(nums[0..i))
        int[] nums = {};
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

//    // 二维前缀数组初始化
//    private void prefix2D(int[][] sum) {
//        for (int i1 = 1; i1 <= m; i1++)
//            for (int i2 = 1; i2 <= n; i2++) {
//                scanf("%d", & a[i1][i2]);
//                sum[i1][i2] = a[i1][i2] + sum[i1 - 1][i2] + sum[i1][i2 - 1] - sum[i1 - 1][i2 - 1];
//            }
//    }
}
