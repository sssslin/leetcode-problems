package com.tags.list.partitionList;

import test.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 1、遍历链表，所以时间复杂度为 O(n)；指针操作，空间复杂度为 O(1);
     * 2、使用了哨兵这个链表中的常用技巧
     * 3、链表类型的题目，指针指向的含义一定要搞清楚，这是做这类题的基本
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        // 存放小于target值的链表
        ListNode smallerList = new ListNode(0);
        // 存放大于target值的链表
        ListNode biggerList = new ListNode(0);

        // 创建两个指针，指向这两个链表
        ListNode current1 = smallerList;
        ListNode current2 = biggerList;

        for(ListNode node = head;node != null; node = node.next) {
            if(node.val < x) {
                current1.next = node;
                current1 = current1.next;
            } else{
                current2.next = node;
                current2 = current2.next;
            }

        }

        current1.next = biggerList.next;
        // 切断原有的引用关系，防止链表成环
        current2.next = null;

        return smallerList.next;
    }
}
