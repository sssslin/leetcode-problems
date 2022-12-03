package com.tags.array.detectCycleII;

public class Solution {

    public static void main(String[] args) {
        System.out.println(111);
    }

    /**
     * 快慢指针问题思考
     * 1、为什么快指针的步长一般是慢指针的两倍，而不是其他倍数
     * 2、为什么在有环的情况下，快指针一定能赶上慢指针
     * 3、如何确定入环点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }

        ListNode point = head;

        while (point != slow) {
            slow = point.next;
            point = point.next;
        }
        return point;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}