package com.tags.string.convert;

import java.util.Arrays;

//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
// L   C   I   R
//E T O E S I I G
//E   D   H   N
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
// 请你实现这个将字符串进行指定行数变换的函数：
// string convert(string s, int numRows);
// 示例 1:
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIR ETOE SIIG EDHN"
//
// 示例 2:
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDRE OEII ECIH NTSG"
//解释:
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G

/**
 * https://www.geekxh.com/1.0.%E6%95%B0%E7%BB%84%E7%B3%BB%E5%88%97/009.html#_02%E3%80%81%E9%A2%98%E7%9B%AE%E5%88%86%E6%9E%90
 * 本地思路和题意还是很明确的，但是关键是找到规律，以及如何做到不重不漏的进行周期性循环。
 * 我的思路其实是完全没问题的，多少个numRows，String数组就有多少个元素，最后将String数组中所有的元素拼接起来即可。
 * 按照数组元素的位置，从0到n分别放置字符，然后再从n-1放到1为止，中间缺失的两个元素，是因为，逆向放置元素，是不包含收尾两个元素的
 */
class Solution {
    public static String convert(String s, int numRows) {
        // 特殊情况判断
        if (numRows == 1) return s;
        // 初始化String数组，否则将会出现null
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        char[] chars = s.toCharArray();
        int len = chars.length;

        int period = numRows * 2 - 2;
        for (int i = 0; i < len; i++) {
            int mod = i % period;
            if (mod < numRows) {
                arr[mod] += chars[i];
            } else {
                arr[period - mod] += String.valueOf(chars[i]);
            }
        }
        // 结果拼接
        StringBuilder res = new StringBuilder();
        for (String ch : arr) {
            res.append(ch);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        String result = convert(s, 4);
        System.out.println(result);
    }
}