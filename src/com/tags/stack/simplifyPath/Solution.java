package com.tags.stack.simplifyPath;

import java.util.Stack;

//以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
//
// 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成
//部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
// 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表
//示绝对路径的最短字符串。
// 示例 1：
// 输入："/home/"
//输出："/home"
//解释：注意，最后一个目录名后面没有斜杠。
//
// 示例 2：
// 输入："/../"
//输出："/"
//解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
//
// 示例 3：
// 输入："/home//foo/"
//输出："/home/foo"
//解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
//
// 示例 4：
// 输入："/a/./b/../../c/"
//输出："/c"
//
// 示例 5：
// 输入："/a/../../b/../c//.//"
//输出："/c"
//
// 示例 6：
// 输入："/a//b////c/d//././/.."
//输出："/a/b/c"
// Related Topics 栈 字符串
// 👍 219 👎 0

/**
 * stack的题目，目前给我的感觉就是，存储。
 * 问题的关键在于，存哪些东西？什么时候存？什么时候删？这才是关键点
 */
public class Solution {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 通过这个API切割出来的数组会产生空字符串，所以再每次进行入栈、出栈操作前，都要去除一下空串
        String[] arr = path.split("/");

        for (int i = 0; i < arr.length; i++) {
            String curr = arr[i].trim();

            if (curr == null || curr.length() == 0 || curr.equals(".")) continue;
            if (curr.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(curr);
            }
        }

        String res = "";

        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        // 返回结果这么写，是以为，如果当时处在根目录，按照要求，要多加一个斜杠
        return res.length() == 0 ? "/" : res;
    }

    public static void main(String[] args) {
        String s = "/../";
        String result = simplifyPath(s);
        System.out.println(result);
    }
}
