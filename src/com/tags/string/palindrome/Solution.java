package com.tags.string.palindrome;

class Solution {
    public static boolean isPalindrome(String s) {
        // corner case
        if (s == null || s.length() < 2) {
            return true;
        }

        // 去掉所有空格,包括首尾,中間
        String str2 = s.replace(" ", "");
        // 清除所有符號,只留下字母 數字 漢字 共3類
        String alphanumericStr = str2.replaceAll("\\p{Punct}", "");

        // 将字符串里的字符全部转成小写
        String lowerCaseStr = alphanumericStr.toLowerCase();
        char[] chars = lowerCaseStr.toCharArray();

        int left = 0, right = chars.length - 1;
        while(left <= right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //  String s = "A man, a plan, a canal: Panama";
        String s = "`l;`` 1o1 ??;l`";
        String s1 = s.replaceAll("\\p{Punct}", "");
        System.out.println(s1);
        System.out.println(isPalindrome(s));
    }
}
