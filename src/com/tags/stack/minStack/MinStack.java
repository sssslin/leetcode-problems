package com.tags.stack.minStack;

import java.util.Stack;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
// 示例:
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
// 提示：
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
public class MinStack {
    /** initialize your data structure here. */

    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    /**
     * 若x <= min，则表示需要更新最小值，将当前最小值进栈push(min)保存前面的最小值，且更新最小值，再将元素进栈push(x)
     * 注意：此处的栈顶元素是此时的栈顶元素也是栈的最小值
     * 若x > min,则直接将元素进栈push(x)
     * @param x
     */
    public void push(int x) {
        if (x <= min) {
            // 把当前的最小值也放进去，
            // 这样之后就可以取出来再次作为最小值了
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    /**
     * 若相同，说明该元素下方埋着前一个的最小值，需要将栈顶元素pop出，还需要将下一个栈顶元素（前一个最小值）pop出，并且赋值给min
     */
    public void pop() {
        if (min == stack.peek()) {
            stack.pop();
            min = stack.pop();
        } else {
            stack.pop();
        }

        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
