package com.tags.string.convert;

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
//输出: "LCIRETOESIIGEDHN"
//
// 示例 2:
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) return s;
        String result = "";

        boolean orderFlag = true;
        String[] strArray = new String[numRows];

        for (int i = 0; i < s.length(); i++) {
            if (orderFlag) {
                int index = i < numRows ? i : i % numRows;
                strArray[index] = strArray[index] + s.substring(i, i + 1);
            }
            else{

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int s = 9% 4;
        System.out.println(s);
    }
}