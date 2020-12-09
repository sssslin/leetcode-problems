package com.tags.string.strStr;

//实现 strStr() 函数。
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。
// 示例 1:
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 示例 2:
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 说明:
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
// Related Topics 双指针 字符串

/**
 * 本题想用题目提示的双指针算法，但是由于各种Corner case没有考虑清楚，各种通不过。
 * 可以明显感觉到，同样的双指针算法，在数组和字符串中的应用，虽然原理相似，但是换一种数据结构，我就一脸懵逼了，
 * 可以说，我根本就没掌握双指针算法。
 *
 * 从这道题中我能学习到的，有以下几点：
 * 1、这道难度定义为easy的题目，有多种方法，除了暴力匹配和双指针，还有KMP算法、动态规划、滑动窗口、Rabin Karp等
 * 2、这是我第一次刷题，熟练度不够，知识体系不够完善，做不出来是可以理解的，但是至少要做到，先把各种题型、数据结构和算法都要涉及到，从这个过程中不断整理知识结构
 * 3、第二遍刷的时候，要求对各种算法进行刻意练习，针对某种算法来强化
 * 4、第三遍刷的时候，要求一题多解
 * 5、对双指针的熟练度不够，思路和Corner case也考虑的不够清楚
 */
class Solution {
    // 暴力匹配
    public static int strStr(String haystack, String needle) {
        // Corner case:
        if (needle.length() == 0) return 0;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        for (int i = 0; i <= h.length - n.length; i++) {
            if (h[i] != n[0]) continue;
            boolean isValid = true;
            for (int j = 0; j < n.length; j++) {
                if (h[i + j] != n[j]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";

        int startIndex = strStr1(haystack, needle);
        System.out.println(startIndex);
    }

    // 双指针
    public static int strStr1(String haystack, String needle) {
        // Corner case:
        if (haystack == null || haystack.length() < needle.length()) return -1;
        if (needle == null || needle.length() == 0) return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int len = 0;
                while (i + len < haystack.length() && len < needle.length() && haystack.charAt(i + len) == needle.charAt(len)) {
                    len++;
                }

                if (len == needle.length()) return i;
            }
        }
        return -1;
    }
}
