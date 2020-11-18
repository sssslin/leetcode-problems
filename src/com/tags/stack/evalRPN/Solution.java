package com.tags.stack.evalRPN;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//根据 逆波兰表示法，求表达式的值。
// 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
// 说明：
// 整数除法只保留整数部分。
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
// 示例 1：
// 输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
// 示例 2：
// 输入: ["4", "13", "5", "/", "+"]
//输出: 6
//解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
// 示例 3：
// 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//输出: 22
//解释:
//该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 逆波兰表达式：
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
// 逆波兰表达式主要有以下两个优点：
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
// Related Topics 栈
// 👍 210 👎 0
public class Solution {
    public static int evalRPN(String[] tokens) {

        // 这个stack用于存储数字
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";
        // 将所有的数字都存入栈中
        for (int i = 0; i < tokens.length; i++) {
            if (!operators.contains(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else if(stack.size() >= 2) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                switch (tokens[i]) {
                    case "+": stack.push(temp2 + temp1);break;
                    case "-": stack.push(temp2 - temp1);break;
                    case "*": stack.push(temp2 * temp1);break;
                    case "/": stack.push(temp2 / temp1);break;
                }
            }
        }

        int result = stack.pop();
        return result;
    }

    /**
     * 1、以下这个题解通过一个包含所有操作符的字符串来减少比较的次数，而不是通过数组的每个字符分别与每种字符比较，
     * 减少了3/4的比较次数
     * 2、用if-else的写法，代码看起来更加的紧凑和简洁
     * @param tokens
     * @return
     */
    public int evalRPN1(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Deque<Integer> stack = new LinkedList<>();
        String operators = "+-*/";
        for(int i = 0;i< tokens.length;i++){
            if(operators.contains(tokens[i])){
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(tokens[i].equals("+")) stack.push(num2 + num1);
                else if(tokens[i].equals("-"))stack.push(num2 - num1);
                else if(tokens[i].equals("*"))stack.push(num2 * num1);
                else if(tokens[i].equals("/"))stack.push(num2 / num1);
            }else stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int result = evalRPN(tokens);
        System.out.println(result);
    }
}
