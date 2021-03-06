package com.tags.binarysearch.divide;

//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
// 返回被除数 dividend 除以除数 divisor 得到的商。
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
// 示例 1:
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
// 示例 2:
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2
// 提示：
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// 由于不能用除号，所以通过左移来代替
// 1.正数统一转化为负数 边界思考量相对较小
// 2.可用二分法对暴力法进行优化
// 3.符号问题 脑子要清醒
// https://blog.csdn.net/dadongwudi/article/details/106851686
public class Solution {
    public static int divide(int dividend, int divisor) {
        // Corner case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        int result = 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        while (dividend <= divisor) {
            int temp = divisor;
            int c = 1;
            while (dividend - temp <= temp) {
                // 左移代表乘，左移一位代表乘2, 12 << 1 = 24
                // 右移代表除, 右移一位代表除2, 12 >> 1 = 6
                temp = temp << 1;
                c = c << 1;
            }
            dividend -= temp;
            result += c;
        }
        return k ? result : -result;
    }

    // 暴力超时
    public int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        int result = 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while (dividend <= divisor) {
            dividend -= divisor;
            result += 1;
        }
        return k ? result : -result;
    }

    public static void main(String[] args) {
        int dividend = 82847;
        int divisor = -412;
        int result = divide(dividend, divisor);
        System.out.println(result);
        System.out.println(Integer.MAX_VALUE);
    }
}
