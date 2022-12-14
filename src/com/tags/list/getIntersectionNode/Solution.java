package com.tags.list.getIntersectionNode;

import test.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode pointA = headA;
        ListNode pointB = headB;

        while (pointA != pointB) {
            pointA = pointA != null ? pointA.next : headB;
            pointB = pointB != null ? pointB.next : headA;
        }
        return pointA;
    }
}
