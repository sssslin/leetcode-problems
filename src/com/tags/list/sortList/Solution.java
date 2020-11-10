package com.tags.list.sortList;

import test.BaseSolution;
import test.ListNode;
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
// 进阶：
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
// 示例 1：
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 示例 2：
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 示例 3：
//输入：head = []
//输出：[]
// 提示：
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
// Related Topics 排序 链表

/**
 * 这个题目和147很像，如果只是为了完成排序，147题的归并排序的解法当然也是可以的。
 * 但是能达到题目要求的复杂度，那么也只有归并排序了
 * 归并排序又分为top to down和down to top
 * top to down
 * time complexity : O(nlogn)
 * space complexity : O(1)
 *
 *  * down to top
 *  * time complexity : O(nlogn)
 *  * space complexity : O(logn)
 */
public class Solution extends BaseSolution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head;

        ListNode pre = null;
        ListNode temp = null;
        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            }else {
                temp = cur.next;
                cur.next = cur.next.next;
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


