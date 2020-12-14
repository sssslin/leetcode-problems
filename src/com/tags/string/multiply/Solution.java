package com.tags.string.multiply;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
// 示例 1:
// 输入: num1 = "2", num2 = "3"
//输出: "6"
// 示例 2:
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
// 说明：
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
// Related Topics 数学 字符串

import java.util.Arrays;

/**
 * 归类：数学
 * 限制条件：
 * 1、不能直接将字符串直接直接转换为数字处理、也不能使用标准库
 * 2、两个字符串的长度最大可以到109，两个109长度的数字相乘，int类型的数据类型会超出范围，甚至是long类型也不行
 */

public class Solution {
    /**
     * 本题的思路就是模拟两数相乘的过程
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {

        if (num1 == null || num2 == null) return "0";

        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();

        int[] res = new int[num1.length() + num2.length()];
        // 初始化数组，防止出现空指针
        Arrays.fill(res, 0);
        // 从个位数开始相乘，所以loop的过程是从字符串的最右边往左遍历
        // 这个双层循环就是模拟两数相乘的逻辑
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                // 两个数相乘的积
                int product = (ch1[i] - '0') * (ch2[j] - '0');
                // res[i + j + 1] 表示原来该位置上的数
                int temp = res[i + j + 1] + product;
                // res[i + j + 1] 表示的是 低位
                res[i + j + 1] = temp % 10 ;
                // 等号左边表示的是res[i + j] 表示的是 高位，等号右边的res[i + j]表示的是原来位置的数
                res[i + j] = res[i + j]  + temp / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean seen = false;
        for (int i = 0; i < res.length; i++) {
            // 这个判断是为了校验，最高位是否为0存在的，只有遇到最高位为非0的数，才开始相加
            if (res[i] == 0 && !seen) continue;
            sb.append(res[i]);
            seen = true;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "9133";
        String num2 = "0";
        String product = multiply(num1, num2);
        System.out.println(product);
    }
}
