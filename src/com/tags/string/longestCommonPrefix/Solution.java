package com.tags.string.longestCommonPrefix;

//编写一个函数来查找字符串数组中的最长公共前缀。
// 如果不存在公共前缀，返回空字符串 ""。
// 示例 1:
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 示例 2:
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 说明:
// 所有输入只包含小写字母 a-z 。

/**
 * 解题思路
 * 取数组的第一个字符串，然后从一个完整的字符串与后续的字符串匹配，然后逐步的将字符串递减。其实是一种朴素的
 * 思路的正确性和可行性：
 * 边界情况：下标是否越界的问题
 *
 * 时间复杂度：最差时间复杂度O(n²) 最好时间复杂度 O(1);
 * 空间复杂度：O(1);
 *
 * 所处阶段：能写出题解，但是出于非常的朴素暴力的写法。本地由于边界情况考虑不清楚，翻车3次。
 * 主要问题：边界情况处理
 */
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        // 用一个字符串来接受结果
        String ans = "";
        if (strs == null || strs.length == 0) return ans;
        if (ans.length() == 1) return ans;
        // 比较组
        String firstStr = strs[0];
        int counter = 0;
        for (int i = firstStr.length(); i > 0; i--) {
            String commonPrefix = firstStr.substring(0, i);
            int len = commonPrefix.length();
            for (int j = 1; j < strs.length; j++) {
                // 边界情况处理，在这里翻车3次
                if (strs[j].length() >= commonPrefix.length() && strs[j].substring(0, len).equals(commonPrefix)) {
                    counter++;
                }
            }
           
            if (counter == (strs.length - 1)) {
                ans = commonPrefix;
                break;
            }
            counter = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        String commonStr = longestCommonPrefix(strs);
        System.out.println(commonStr);
    }
}
