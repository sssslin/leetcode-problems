package com.tags.list.rotateRight;

import test.BaseSolution;
import test.ListNode;

//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL

// 示例 2:
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针
public class Solution extends BaseSolution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        // 这里是为了计算出链表的长度，为下一步计算双指针具体移动的次数做准备
        int len = 0;
        // 快节点先遍历到末尾
        while (fast != null) {
            len++;
            fast = fast.next;
        }

        // 重新指向链表头结点
        fast = head;
        // k % len是为了处理k特别大的时候，最终指针需要移动的位置
        for (int i = 0; i < k % len; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 开始处理指向关系
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
