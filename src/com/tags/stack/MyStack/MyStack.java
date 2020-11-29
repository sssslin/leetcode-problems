package com.tags.stack.MyStack;


import java.util.LinkedList;
import java.util.Queue;
import java.util.SimpleTimeZone;

/**
 * //使用队列实现栈的下列操作：
 * // push(x) -- 元素 x 入栈
 * // pop() -- 移除栈顶元素
 * // top() -- 获取栈顶元素
 * // empty() -- 返回栈是否为空
 * // 注意:
 * // 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
 * //法的。
 * // 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * // 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * //
 * // Related Topics 栈 设计
 * // 👍 239 👎 0
 */

/**
 * 队列的前端======》 栈顶
 * 队列的后端======》栈底
 *
 */
public class MyStack {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        // 根据queue先进先出的原则，把之前的元素弹出来，然后放到新加的元素后面，也就是说，做了一个逆序操作
        // 因为要永远保持队列头部对应栈顶
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        int i = myStack.top(); // return 2
        System.out.println(i);
        int j = myStack.pop(); // return 2
        System.out.println(j);

        myStack.empty(); // return False
        System.out.println(myStack.empty());
    }
}
