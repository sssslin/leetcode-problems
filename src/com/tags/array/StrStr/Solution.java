package com.tags.array.StrStr;

/**
 * @author: linjunfeng
 * @Title: Solution
 * @Description:
 * @date: 2022/6/12 17:40
 */
public class Solution {


    public static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) return 0;

        int left = 0, right = needle.length() - 1;
        while (right < haystack.length()) {
            if (haystack.substring(left, right + 1).equals(needle)) {
                return left;
            }
            left++;
            right++;
        }
        return  -1;
    }

    public static void main(String[] args) {

        String haystack = "aaaaa";
        String needle = "bba";
        int index = strStr(haystack, needle);
        System.out.println(index);
    }
}
