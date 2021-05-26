package com.tags.array.LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
       String  s = "abcabcbb";
       lengthOfLongestSubstring(s);
    }

    /**
     * 本题问题解析
     * 1.使用了滑动窗口，并使用HashMap进行优化
     * 2.为了防止出现指针右移的问题，更新left位置时，需要使用Math.max()方法，来取最大值
     * 3.时间复杂度：O(n)  空间复杂度：O(n);
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                // 这里使用max函数，主要是为了避免指针左移
                left = Math.max(left, map.get(c) + 1);
                System.out.println(String.format("左指针的位置：%s",left));
            }
            map.put(c, right++);
            res = Math.max(res, right - left);
            System.out.println(String.format("右指针的位置：%s",right));
            System.out.println(String.format("长度：%s",res));
        }
        return res;
    }
}
