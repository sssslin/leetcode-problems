package com.tags.stack.isValid;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
// 有效字符串需满足：
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。
// 示例 1:
// 输入: "()"
//输出: true
//
// 示例 2:
// 输入: "()[]{}"
//输出: true
//
// 示例 3:
// 输入: "(]"
//输出: false
//
// 示例 4:
// 输入: "([)]"
//输出: false
//
// 示例 5:
// 输入: "{[]}"
//输出: true

import java.util.Stack;

// Related Topics 栈 字符串
// 👍 1968 👎 0

/**
 * 这种解法的思路在于，用一个stack来存储每一个遇到的正括号，
 * 到遇到反括号的时候，则需要将stack中的括号给push出来进行匹配，如果为空
 *  time complexity : O(n)
 *  space complexity : O(1)
 */
public class Solution {
    public static boolean isValid(String s) {

        Stack<Character> mark = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                mark.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (mark.isEmpty()) return false;

                char cur = mark.pop();
                if (cur == '(' && s.charAt(i) != ')') return false;
                if (cur == '[' && s.charAt(i) != ']') return false;
                if (cur == '{' && s.charAt(i) != '}') return false;
            }
        }

        if (mark.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "{[]}";
        boolean flag = isValid(s);
        System.out.println(flag);
    }
}
