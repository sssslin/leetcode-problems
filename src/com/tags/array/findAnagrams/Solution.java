package com.tags.array.findAnagrams;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/shi-yong-hua-dong-chuang-kou-jie-ti-hen-rong-yi-by/
 */
public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        // init
        List<Integer> list = new ArrayList<>();
        // corner case
        if (s == null || p == null || s.length() < p.length()) return list;

        // init
        int left = 0, right = 0;
        int count = p.length();
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
           hash[c]++;
        }

        // sliding window
        while(right < s.length()) {
            if (hash[s.charAt(right)] > 0) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if (count == 0) {
                System.out.println(left);
                list.add(left);
            }

            if (right - left == p.length()) {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }

        return list;
    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(Arrays.toString(anagrams.toArray()));
    }
}
