package com.tags.binarysearch.mySqrt;

//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
// 示例 1:
// 输入: 4
//输出: 2
// 示例 2:
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
// Related Topics 数学 二分查找

/**
 * 本地还是很简单的，直接套用二分法的思想即可。但是第一次提交的时候，2147395599这个边界情况通不过.
 * 思路还是按照自己总结的思路，分3步走
 * 1、划定区间，通过题目给定的例子划分即可
 * 2、
 */
public class Solution {
    public static int mySqrt(int x) {
        if (x == 1 || x == 0) return x;

        // 以8为例
        // 划定区间：0-8中间值为4,4的平方显然大于8，那么区间的划分，则成为[left,mid-1],[mid, right]，
        // 这种情况，取二分的时候，需要加1，防止进入死循环

        long left = 0, right = x;
        while (left < right) {
            long mid = (left + right + 1) / 2;// 加1避免死循环
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // 在这道题目中，由于终止条件是left < right，也就是说当left == right的时候跳出循环，
        // 所以，返回的是right还是left都是一样的。
        return (int) right;
    }

    public static void main(String[] args) {
        // 假如用int会怎么样
        int x = 2147395599;
        int result = mySqrt1(x);
        System.out.println(result);
    }

    public static int mySqrt1(int x) {
        if (x == 1 || x == 0) return x;

        // 以8为例
        // 划定区间：0-8中间值为4,4的平方显然大于8，那么区间的划分，则成为[left,mid-1],[mid, right]，
        // 这种情况，取二分的时候，需要加1，防止进入死循环

        long left = 0, right = x;
        while (left < right) {
            long mid = (left + right + 1) / 2;// 加1避免死循环
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // 在这道题目中，由于终止条件是left < right，也就是说当left == right的时候跳出循环，
        // 所以，返回的是right还是left都是一样的。
        return (int) right;
    }

    public static int mySqrt2(int x) {
        if (x == 1 || x == 0) return x;

        // 以8为例
        // 划定区间：0-8中间值为4,4的平方显然大于8，那么区间的划分，则成为[left,mid-1],[mid, right]，
        // 这种情况，取二分的时候，需要加1，防止进入死循环

        long left = 0, right = x;
        while (left < right) {
            long mid = (left + right) / 2;// 加1避免死循环
            if (mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 在这道题目中，由于终止条件是left < right，也就是说当left == right的时候跳出循环，
        // 所以，返回的是right还是left都是一样的。
        return (int) right;
    }
}
