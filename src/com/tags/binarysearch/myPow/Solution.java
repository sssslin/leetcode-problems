package com.tags.binarysearch.myPow;
//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
// 示例 1:
// 输入: 2.00000, 10
//输出: 1024.00000
// 示例 2:
// 输入: 2.10000, 3
//输出: 9.26100
// 示例 3:
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
// 说明:
// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
// Related Topics 数学 二分查找
// 👍 559 👎 0

/**
 * 区间的划分：
 * 终止条件：
 * 边界情况：
 * n的范围为int的取值范围，所以得考虑整数溢出的可能性；
 * x的取值范围中，貌似0和1这两种情况需要特殊考虑
 * 0的负数次幂是不合法的输入，该如何解决
 */
public class Solution {
    public static double myPow(double x, int n) {

      //  Java 代码中 int32 变量 n \in [-2147483648, 2147483647]n∈[−2147483648,2147483647] ，
      //  因此当 n = -2147483648n=−2147483648 时执行 n = -n 会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
      //  https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
        // corner case
        if (x == 0) return x;

        long b = n;
        // 该状态的作用是，当n为奇数的时候，来对齐偶数所设置的
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        double rest = 1.0;
        while (b >= 1) {
            // 判断n为奇数的情况
            if (b % 2 == 1) {
                rest *= x;
            }
            x *= x;
            b = b >> 1;
        }
        return rest;
    }

    public static void main(String[] args) {
        double x = 2.1000;
        double result = myPow(x, 3);
        System.out.println(result);
    }
}
