package com.tags.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 来offer：https://www.youtube.com/watch?v=9qFR2WQGqkU
 * 1. corner case
 * 2. 初始化变量：
 * 2.1. slow指针
 * 2.2. minLen即最终需要返回的值
 * 2.3. 将子串的字符存入一个map,key:字符 ,value : 字符需要匹配的次数
 * 2. 4. matchCount匹配是否存在可行解，当map.size() = matchCount则说明存在可行解
 * 2. 5. fast指针进行外层循环，寻找是否存在可行解，直到map.size() =  matchCount时slow指针开始移动,
 * 外层循环是一个matchCount++的过程，内层循环是matchCount--的过程，当matchCount<map.size()说明当前窗口已经不符合要求，右端点重新开始移动。直到右端点到达右边界，循环停止
 * 3. 判断minLen是否被更新过，如果没被更新过，则返回默认值
 * <p>
 * 难点：当一个字符出现多次的时候，该如何处理的问题
 */
public class MinimumWindowSubstring {

    // Assumption: s and t are both not null
    public static String minWindow(String s, String t) {
        // corner case:
        if (s.length() < t.length()) {
            return "";
        }

        // 用t里面的元素构造成一个map
        Map<Character, Integer> wordDict = constructWordDict(t);
        // init
        int slow = 0, minLen = Integer.MAX_VALUE, matchCount = 0, index = 0;
        // sliding window
        for (int fast = 0; fast < s.length(); fast++) { // 外层循环寻找是否存在可行解
            char ch = s.charAt(fast);

            Integer count = wordDict.get(ch);
            if (count == null) {
                continue;
            }
            wordDict.put(ch, count - 1);

            // count - 1并不影响当前的值
            if (count == 1) {
                // 1 -> 0
                matchCount++;
            }

            while (matchCount == wordDict.size()) { // 内层循环寻找是否存在最优解
                // find a valid substring
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }

                System.out.println(slow);
                char leftMost = s.charAt(slow++);
                Integer leftmostCount = wordDict.get(leftMost);
                if (leftmostCount == null) {
                    continue;
                }

                wordDict.put(leftMost, leftmostCount + 1);
                if (leftmostCount == 0) {
                    // 0 -> 1
                    matchCount--;
                }
            }
        }
        System.out.println(s.substring(index, index + minLen));
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }

    /**
     * 用t里面的元素构造成一个map
     * 构造逻辑：map中不存在当前字符，则value设为1；如果map中存在当前字符，则value++
     *
     * @param t
     * @return
     */
    private static Map<Character, Integer> constructWordDict(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);
        System.out.println(result);
    }
}
