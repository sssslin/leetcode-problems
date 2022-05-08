package com.tags.list.removeNthFromEnd;

import test.BaseSolution;
import test.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针

/**
 * 本地采用的是双指针的快慢指针法，其中的关键在于
 * 要删除的节点 = 前一个节点 - 后一个节点
 * 本地的关键在于，如何fast指针要事先移动多少步
 * fast事先要移动 N + 1步，和slow指针，保持N个节点的距离
 * 然后通过slow节点指向下下个节点的方式来达到删除节点的效果
 */
public class Solution extends BaseSolution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // 创建哨兵节点
        ListNode dummyNode = new ListNode(0);
        // 创建双指针，初始位置在哨兵节点
        ListNode fast = dummyNode, slow = dummyNode;
        // 哨兵节点指向原有头节点
        slow.next = head;

        // fast指针先往前走n + 1步，保证 fast 与 slow之间间隔 n 个节点
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // fast 与 slow 指针同时移动，直到fast指针指向null
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow指针的后一个节点就是需要删除的节点
        slow.next = slow.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = removeNthFromEnd(head, 2);

    }

}
