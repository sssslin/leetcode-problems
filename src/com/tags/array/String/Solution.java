package com.tags.array.String;

/**
 * 套用双指针之左右指针模板
 */
public class Solution {

    public static void reverseString(char[] s) {
        if(s == null || s.length == 0) return;

        int left = 0, right = s.length - 1;
        while(left < right) {
            swap(s, left, right);
            left++;
            right--;

            int i = Integer.MAX_VALUE;
        }
    }

    private static void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
