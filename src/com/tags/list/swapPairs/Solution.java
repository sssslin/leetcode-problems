package com.tags.list.swapPairs;

import test.BaseSolution;
import test.ListNode;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

// 示例 1：
//
//
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]

// 示例 2：
//
//
//输入：head = []
//输出：[]

// 示例 3：
//输入：head = [1]
//输出：[1]

// 提示：

// 链表中节点的数目在范围 [0, 100] 内
// 0 <= Node.val <= 100
//
// Related Topics 链表
// 👍 720 👎 0

/**
 * 对于这个题目，看到例子，我首先想到的是：如果链表中的元素个数是奇数个，那么
 * 两两交换是如何做的呢？我觉得这是一个边界条件
 *
 * 链表最难的地方，其实是指针的理解，因为对指针理解不够的情况下，很容易出现指针乱指
 * 导致出现各种问题的情况。
 *
 * 对于这种节点交换的问题，最好的做法就是，bug然后画图
 */
public class Solution extends BaseSolution {
    public ListNode swapPairs(ListNode head) {
        // 这里应用的技巧叫做哨兵指针
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // 结束条件的判断
        while (current.next != null && current.next.next != null) {
            swap2(current);
            current = current.next.next;
        }
        // 由于使用了哨兵，所以，返回的是dummy的next节点
        return dummy.next;
    }

    private void swap2(ListNode pre) {
        // 等号的左边是引用，可以理解为指针，比如，dummy保存了pre.next的内存地址
        ListNode dummy = pre.next;
        pre.next = dummy.next;
        dummy.next = dummy.next.next;
        pre.next.next = dummy;
    }
}
