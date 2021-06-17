package com.tags.string.checkInclusion;

import java.util.Arrays;

/**
 * https://www.programminghunter.com/article/188527011/
 */
public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
            // init
            int l1 = s1.length();
            int l2 = s2.length();

            int[] c1 = new int[26];
            int[] c2 = new int[26];

            for (char ch : s1.toCharArray()) {
                c1[ch - 'a']++;
            }

        for (int i = 0; i < l2; i++) {
            if (i >= l1) {
                char ch = s2.charAt(i - l1);
                --c2[ch - 'a'];
            }

            c2[s2.charAt(i) - 'a']++;

            if (Arrays.equals(c1, c2)) {
                return true;
            }
        }
            return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean flag = checkInclusion(s1, s2);
        System.out.println(flag);

    }

}
