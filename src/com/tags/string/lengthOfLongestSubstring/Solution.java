package com.tags.string.lengthOfLongestSubstring;

import java.util.HashMap;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
// 示例 1:
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 示例 2:
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 示例 3:
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4617 👎 0
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        // j指向不重复的起点，i是右指针
        for (int i = 0, j = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                // 当出现重复的点的时候，j要向后移动一位，就是左边界要向右移动
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }

            // 每次都记录每个字符最后出现的位置
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);

        }

        return max;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}
