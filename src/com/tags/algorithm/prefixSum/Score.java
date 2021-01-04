package com.tags.algorithm.prefixSum;

import java.util.Arrays;

public class Score {

    public static void main(String[] args) {
        int[] scores = {133, 136, 132, 133}; // 存储着所有同学的分数
        int[] count = prefixSum(scores, 130, 135);
        System.out.println(Arrays.toString(count));
    }

    // 前缀和的其中一种应用
    private static int[] prefixSum(int[] scores, int start, int end) {
        // 试卷满分 150 分
        int[] count = new int[150 + 1];
        // 记录每个分数有几个同学
        for (int score : scores) {
            // 该操作是给数组赋值
            count[score]++;
        }

        // 构造前缀和
        for (int i = 1; i < count.length; i++)
            count[i] = count[i] + count[i-1];
        return count;
    }


}
