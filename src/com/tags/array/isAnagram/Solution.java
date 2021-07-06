package com.tags.array.isAnagram;

/**
 * 相关题目：
 * 383、赎金信
 * 49、字母异位次分组
 * 438、找到字符串中所有字母异位词
 *
 */
public class Solution {
    /**
     * 解题思路：
     * 创建一个空的字符数组，两个需要比较的字符串，任意取一个字符串，将字符串里的字符依次存入数组中，
     * 遍历完第一个字符串之后，遍历第二个字符串。用数组里的字符去相减。
     * 如果到最后，数组里的所有元素都为0，那么，说明这两个字符是字母异位词
     * 本质上，这是一个对数组进行一存一取操作的过程。个人理解，完全可以用栈或者map实现类似的操作
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        // corner case
        if (s.length() != t.length()) {
            return false;
        }

        char[] records = new char[26];

        for (char ch : s.toCharArray()) {
            records[ch - 'a'] += 1;
        }

        for (char ch : t.toCharArray()) {
            records[ch - 'a'] -= 1;
        }

        // valid
        for (char element : records) {
            if (element != 0) {
                return false;
            }
        }


        return true;
    }
}
