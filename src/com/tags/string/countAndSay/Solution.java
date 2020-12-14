package com.tags.string.countAndSay;

//给定一个正整数 n ，输出外观数列的第 n 项。
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
// 你可以将其视作是由递归公式定义的数字字符串序列：
// countAndSay(1) = "1"
// countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
// 前五项如下：
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//第一项是数字 1
//描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
//描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
//描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
//描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
// 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成
//一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
// 例如，数字字符串 "3322251" 的描述如下图：
// 示例 1：
//输入：n = 1
//输出："1"
//解释：这是一个基本样例。
// 示例 2：
//输入：n = 4
//输出："1211"
//解释：
//countAndSay(1) = "1"
//countAndSay(2) = 读 "1" = 一 个 1 = "11"
//countAndSay(3) = 读 "11" = 二 个 1 = "21"
//countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
// 提示：
// 1 <= n <= 30
// Related Topics 字符串
/*  题意描述
    1
    2 描述的是1，是一个1，也就是11
    3 描述的是11，是两个1，也就是21
    4 描述的是21，是一个2一个1，也就是12-11
    5 描述的是1211, 是一个1，一个2，两个1，也就是11-12-21
    6 描述的是111221，是三个1，两个2，一个1，也就是31-22-11
    7 描述的是312211，是一个3一个1两个2两个1，也即是13-11-22-21
    以此类推
 */
class Solution {
    public static String countAndSay(int n) {
        // Corner cases
        if (n == 1) return "1";
        // 最基本的情况
        String result = "1";

        for (int i = 2; i <= n; i++) {// n表示的是行数，由题意可知，第一行，是1，所以第n行需要循环n-1次
            // 用来拼接字符串的工具
            StringBuilder sb = new StringBuilder();

            for (int j = 0;j  < result.length();) {// 这层循环是在描述字符的构建规则
                char curr = result.charAt(j);
                int count = 0;

                // 前面一个条件是为了防止越界，后面这个是判断是否有2个或2个以上的连续字符
                while (j < result.length() && result.charAt(j) == curr) {
                    count++;
                    j++;
                }

                sb.append(count);
                sb.append(curr);
            }// 内层循环到此处为止

            result = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        String result = countAndSay(n);
        System.out.println(result);
    }
}