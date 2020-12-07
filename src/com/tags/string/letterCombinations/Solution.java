package com.tags.string.letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
// 示例:
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 深度优先搜索 递归 字符串 回溯算法

/**
 * 解题思路
 * 做这道题的时候，只有非常模糊的思路。但是在YouTube上看到一个讲解视频，看到了一个题解，非常详尽的讲述了如何分析一道题。
 * 也让我学到了，良好的编码习惯是怎么样的。
 * 1、先写出整体的思路和框架
 * 2、写完之后要检查和测试
 * 3、Corner case要考虑好
 * 4、通过注释来表明思路
 * <p>
 * 算法题几乎都要画图，但是自己画图经常画的不够详细，对于每一步代表的意义过于模糊
 * 思路的正确性和可行性：
 * 边界情况：
 * <p>
 * 时间复杂度：
 * 空间复杂度：
 * <p>
 * 所处阶段：
 * 主要问题：
 * https://www.youtube.com/watch?v=uMmFXWs_ZMY&list=PLTNkreZiUTIL-S_VJBLRxlmGktAQtla-m&index=26&ab_channel=%E6%9D%A5Offer-LaiOffer
 * 本题周末要反复学习
 */
class Solution {
    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        // corner case
        if (digits == null || digits.length() == 0) return res;

        // 用于拼接字符的一个工具
        StringBuilder sb = new StringBuilder();
        // 用于存储映射的一个工具
        Map<Integer, String> dict = constructWordDict();
        dfsHelper(digits, 0, sb, res, dict);

        return res;
    }

    /**
     *
     * @param digits
     * @param index 层数
     * @param sb  字符拼接工具
     * @param res 结果集
     * @param dict 映射集合
     */
    private static void dfsHelper(String digits, int index, StringBuilder sb, List<String> res, Map<Integer, String> dict) {
        // base case 即循环终止条件
        if (digits.length() == index) {
            res.add(sb.toString());
            return;
        }

        // recursive rule
        int ch = digits.charAt(index) - '0';
        String values = dict.get(ch);

        for (char c : values.toCharArray()) {
            sb.append(c);
            dfsHelper(digits, index + 1, sb, res, dict);
            // recover
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static Map<Integer, String> constructWordDict() {
        Map<Integer, String> wordDict = new HashMap<>();

        wordDict.put(0, "");
        wordDict.put(1, "");
        wordDict.put(2, "abc");
        wordDict.put(3, "def");
        wordDict.put(4, "ghi");
        wordDict.put(5, "jkl");
        wordDict.put(6, "mno");
        wordDict.put(7, "pqrs");
        wordDict.put(8, "tuv");
        wordDict.put(9, "wxyz");
        return wordDict;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result.toString());
    }
}

