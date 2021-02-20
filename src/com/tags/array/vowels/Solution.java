package com.tags.array.vowels;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static String reverseVowels(String s) {
        // corner case
        if(s == null || s.length() == 0)  return "";

        // 构造一个包含所有元音字母的set集合
        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        Set<Character> set = new HashSet<>(10);
        for(int i = 0; i < vowels.length; i++) {
            set.add(vowels[i]);
        }

        char[] chars = s.toCharArray();
        // 进行对撞指针操作
        int left = 0, right = chars.length - 1;
        while(left < right) {
            while(left < right && !set.contains(chars[left])) {
                left++;
            }

            while(left < right && !set.contains(chars[right])) {
                right--;
            }

            // 交换
            swapChar(left, right, chars);

            // 交换成功后各自向中间移动一位
            left++;
            right--;

        }

        s = String.valueOf(chars);
        return s;
    }

    private static void swapChar(int left, int right, char[] chars) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        s = reverseVowels(s);
        System.out.println(s);

    }
}
