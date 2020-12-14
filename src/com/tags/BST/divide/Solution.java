package com.tags.BST.divide;

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
//
// https://leetcode-cn.com/problems/divide-two-integers/solution/can-kao-liao-bie-ren-de-er-fen-fa-dan-shi-bu-yong-/
public class Solution {
    public int divide(int dividend, int divisor) {
        // corner case
        if (dividend == 0 || divisor == 0) return 0;
        //除数是-2147483648
        if (dividend == -2147483648 && divisor == -1) return Integer.MAX_VALUE;
        //被除数是-2147483648的问题
        if (dividend == -2147483648 && divisor == -2147483648) return 1;
        if (divisor == -2147483648) return 0;

        boolean flag = false;//判断是不是-2147483648
        if (dividend == -2147483648) {
            dividend = dividend + 1;//+1保证不溢出
            flag = true;
        }

        boolean negtive = (dividend ^ divisor) < 0;//异或，如果两个符号不同，异或之后最高位符号必定为1，即为负数
        int dividend1 = dividend > 0 ? dividend : 0 - dividend;//将数字都变成正数，便于处理
        int divisor1 = divisor > 0 ? divisor : 0 - divisor;
        int res = 0, count = 1;//存储结果，以及除的次数
        while (dividend1 >= divisor1) {
            dividend1 = dividend1 - divisor1;
            res = res + count;
            if (dividend1 < Math.abs(divisor)) {
                if (!flag) {
                    return negtive ? 0 - res : res;
                } else {//做了+1处理，判断最后的余数还能不能整除
                    if (dividend1 + 1 == Math.abs(divisor)) {
                        return negtive ? 0 - res - 1 : res + 1;
                    } else {
                        return negtive ? 0 - res : res;
                    }
                }
            }
            if (dividend1 - divisor1 < divisor1) {//无法倍增
                divisor1 = Math.abs(divisor);
                count = 1;
                continue;
            }
            //倍增
            divisor1 += divisor1;
            count += count;
        }
        return 0;

    }
}
