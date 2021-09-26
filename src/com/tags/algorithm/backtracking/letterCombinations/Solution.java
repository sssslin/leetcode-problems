package com.tags.algorithm.backtracking.letterCombinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
     if (digits.equals("")) return new ArrayList<>();

     String[] m = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wyxz"};
     List<String> res = new ArrayList<>();
     StringBuilder sb = new StringBuilder();
     traverse(digits, m, sb, res, 0);
     return res;
    }

    private void traverse(String digits, String[] m, StringBuilder sb, List<String> res, int idx) {
        if (idx >= digits.length()) {
            res.add(sb.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        String opts = m[digit - 2];
        for (int i = 0; i < opts.length(); i++) {
            char c = opts.charAt(i);
            sb.append(c);
            traverse(digits, m, sb, res, idx + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
