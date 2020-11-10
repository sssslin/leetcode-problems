package com.tags.list.reorderList;

import test.BaseSolution;
import test.ListNode;
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
// 示例 1:
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
// 示例 2:
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
// 👍 743 👎 0

/**
 * 本题这种解法的思路很简单，涉及到的链表的翻转，合并，还有中点寻找的代码编写是我特别薄弱的地方，周末需要重点练习
 */
public class Solution extends BaseSolution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        // 将链表断开
        mid.next = null;

        // step 2. 反转第二部分的链表
        l2 = reverse(l2);

        ListNode l1 = head;
        // step 3. 将链表的第一部分和翻转后的另外一条链表给拼接起来
        merge(l1, l2);
    }

    // 用快慢指针的方式寻找链表的终点，当快指针到链表末端时，慢指针刚好到一半
    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static void merge(ListNode head1, ListNode head2) {
        while (head2 != null) {
            ListNode next = head1.next;
            head1.next = head2;
            head1 = head2;
            head2 = next;
        }
    }
}


