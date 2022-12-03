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

    /**
     * 1、使用快慢指针，将两个链表给分成两部分
     * 2、分别对两个链表进行排序
     * 3、合并链表
     * @param head
     * @return
     */
    public  ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        head = sortList(head);
        head2 = sortList(head2);
        return merge(head, head2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next =  list1;
                list1 = list1.next;
            } else {
               cur.next = list2;
               list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 == null) {
            cur.next = list2;
        }

        if (list2 == null) {
            cur.next = list1;
        }
        return dummy.next;
    }


    /**
     * 从这道题，我至少可以学习以下3点
     * 1、如何合并有序链表
     * 2、归并排序的引用
     * 3、递归
     *
     * 有以下问题需要不断练习
     * 1、搞清楚指针的指向关系
     * 2、搞清楚什么时候是节点、什么时候是指针
     */

}


