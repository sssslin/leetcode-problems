package com.tags.list.insertionSortList;

import test.BaseSolution;
import test.ListNode;

import java.util.List;
//对链表进行插入排序。
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
// 插入排序算法：
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
// 重复直到所有输入数据插入完为止。

// 示例 1：
// 输入: 4->2->1->3
//输出: 1->2->3->4
//
// 示例 2：
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
//
// Related Topics 排序 链表
// 👍 230 👎 0
public class Solution extends BaseSolution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode cur = head;

        ListNode pre = null;
        ListNode temp = null;

        while (cur != null && cur.next != null) {
            // 说明本来就有序，则向下一个节点，开始遍历
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                // 先将要删除的节点，通过temp指针给保存起来
                temp = cur.next;
                // next指针指向下一个节点
                cur.next = cur.next.next;
                // 从dummy节点开始遍历
                pre = dummy;
                while (pre.next.val <= temp.val) {
                    pre = pre.next;
                }
                // temp节点指向新的节点
                temp.next = pre.next;
                // temp节点的头部连上
                pre.next = temp;

            }
        }
        return dummy.next;
    }
}


