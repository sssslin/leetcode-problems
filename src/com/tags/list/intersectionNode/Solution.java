package com.tags.list.intersectionNode;

import test.BaseSolution;
import test.ListNode;

/**
 * 这个题目有一个比较容易误解的是，不是值相等，就等于是相交。
 * 要求的是内存地址相同，才算相交，示例1中，节点值为1的两个节点，虽然值一样，但是属于不同节点，所以不符合条件
 */
public class Solution extends BaseSolution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;
        // 这种解题方法的关键在于，让两个指针跑完两个链表的长度，只要有相交，那么总有交叉点会相遇
        while (a != b) {
         a = a == null ? headB : a.next;
         b = b == null ? headB : b.next;
        }
        // 由于退出条件是 a == b ，所以返回值为a或者b都是正确的
        return a;
    }
}
