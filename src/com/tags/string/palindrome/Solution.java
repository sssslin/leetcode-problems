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
        System.out.println(right);
        while (left <= right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    /*
        这题可以转换成char，然后用char的API来做，效率会提高很多
        1、Character.isLetterOrDigit()直接用这个API来判断是否是数字或者字母，
        而且题目中alphanumeric这个代词也表示字符或数字，所以我上面的第一种写法其实是有一定问题的，如果
        题目的校验稍微严一点，那么我上面的那个写法就会失效

        这个题目的意思确实非常简单，但是目前还是不能做到非常流畅的完成这个代码，
        周末有空要加强练习
     */
    public static boolean isPalindrome1(String s) {
        int left = 0, right = s.length() - 1;
        char head, tail;
        if(right < 0) return true;

        while(left < right) {
            head = s.charAt(left);
            tail = s.charAt(right);

            if(!Character.isLetterOrDigit(head)) {
                left++;
            }

            if(!Character.isLetterOrDigit(tail)) {
                right--;
            }

            if(Character.isLetterOrDigit(head) && Character.isLetterOrDigit(tail)) {
                if(Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }

                left++;
                right--;
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
        System.out.println(isPalindrome1(s));
    }
}
