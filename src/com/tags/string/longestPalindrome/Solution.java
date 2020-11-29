package com.tags.string.longestPalindrome;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
// 示例 1：
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 示例 2：
// 输入: "cbbd"
//输出: "bb"
// Related Topics 字符串 动态规划
// 👍 2931 👎 0
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 题解参考地址：
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 */
class Solution {
   // 中心扩散法
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }

    // 动态规划
    public String longestPalindrome2(String s) {
        // 特判
        int len = s.length();
        // 字符串长度小于2，则说明只有一个字符，或者没有字符，直接返回结果即可
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // i 表示 l ,j 表示 r
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    // 字符不相等，说明不是回文串
                    dp[i][j] = false;
                } else {
                    // 字符长度小于3，直接得出
                    // 这判断条件不是凭空得出的，是根据边界条件[i+1, j-1]长度小于2，即说明i和j立马要重合了
                    // (j -1) - (i + 1) + 1 < 2,简化之后得出
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 进入这里，说明，最外层是回文串，那么继续往里面判断
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要是回文子串，都进行记录，待遍历完成后统一处理返回的子串
                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    // j - i + 1 表示字符的长度
                    maxLen = j - i + 1;
                    begin = i;
                }

            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
//leetcode submit region end(Prohibit modification and deletion)