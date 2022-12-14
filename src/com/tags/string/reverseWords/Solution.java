package com.tags.string.reverseWords;

public class Solution {

    public static void main(String[] args) {
        String s = "  hello world  ";

        String result = reverseWords(s);
        System.out.println(result);
    }

    private static String reverseWords(String s) {

        // 消除首尾的空格，以及单词中间多余的空格
        StringBuilder sb = removeExtraSpace(s);
        // 反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 反转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    private static void reverseString(StringBuilder sb, int start, int end) {

        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }

    }

    private static StringBuilder removeExtraSpace(String s) {

        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            while (c != ' ' || sb.charAt(s.charAt(end)) != ' ') {
                sb.append(c);
            }
        }
        return sb;

    }

    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }

            reverseString(sb, start, end);
            start = end + 1;
            end = start + 1;
        }
    }


}
