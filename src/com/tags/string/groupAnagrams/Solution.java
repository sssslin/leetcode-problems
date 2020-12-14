package com.tags.string.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
// 示例:
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
// 说明：
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
// Related Topics 哈希表 字符串
public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 使用hashmap的解法，核心的是以下3行代码，如果属于字母异位词，那么排序之后，他们的key是相等的，将会放入同一个list中
            // 如果不是异位词，那么重新构建一个 string--->list的映射关系即可
            // 最后将结果
            char[] s_arr = strs[i].toCharArray();
            Arrays.sort(s_arr);
            String key = String.valueOf(s_arr);

            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(key, temp);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> list : result) {
            System.out.println(list.toString());
        }
    }
}
