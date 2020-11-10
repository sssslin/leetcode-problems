package com.tags.list.deleteDuplicates2;

import test.BaseSolution;
import test.ListNode;

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
// Related Topics 链表
// 👍 384 👎 0

/**
 * 题意分析：给定了一个排序链表，如果一个数字出现了两次或两次以上，那么需要将这个数字从链表中删除
 * 1、从示例2可以分析出，这个题目需要dummy节点，否则直接删掉会出现空指针问题
 * 2、另外一个问题就是，如何保证重复出现的数字被删干净，删完之后的链表该如何重新衔接起来
 */
// https://www.youtube.com/watch?v=w16pq8_DVno&ab_channel=JacobHuang
public class Solution extends BaseSolution {
    public ListNode deleteDuplicates(ListNode head) {
        // 当链表的第一个节点和第二个节点相同的时候,那么这两个节点都该被删除
        ListNode dummy = new ListNode(0);
        // 将dummy和head连接起来
        dummy.next = head;

        // 双指针，一个指向dummy节点，一个指向cur节点
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            // 当相邻两个节点重复的时候，应该要移动cur节点
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            cur = cur.next;
            if (pre.next.next == cur)
                // pre指针向后移动一个位置
                pre = pre.next;
            else
                // 说明指针中间有重复值，pre.next直接指向current
                pre.next = cur;
        }
        return dummy.next;
    }
}
