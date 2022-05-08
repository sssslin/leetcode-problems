package com.tags.dp.climbStairs;

/**
 * @author: linjunfeng
 * @Title: Solution
 * @Description:
 * @date: 2022/4/5 9:21 AM
 */
public class Solution {
    public static int climbStairs(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

            System.out.print(dp[i - 1]);
            System.out.print("  ");
            System.out.print(dp[i - 2]);
            System.out.print("  ");
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int count = climbStairs(4);
    }
}
