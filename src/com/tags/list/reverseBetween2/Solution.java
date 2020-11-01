package com.tags.list.reverseBetween2;

import test.BaseSolution;
import test.ListNode;

//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表

/**
 * 解题思路：
 * 这个题目要求的是翻转链表，为了避免处理各种边界条件，所以我们需要一个哨兵节点指向链表的头节点。
 * 另外需要两根指针，分别记录m,n指向的节点，之后当扫描完m,n之后，开始进行反转
 *
 * 看了题解之后，更加准确的说法是：双指针+头插法
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
 * 相似题型：206
 */
public class Solution extends BaseSolution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;
        while (step < m - 1) {
            g = g.next; p = p.next;
            step ++;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }
}
