package com.tags.list.partition;

import test.BaseSolution;
import test.ListNode;
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
// 你应当保留两个分区中每个节点的初始相对位置。
// 示例:
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// Related Topics 链表 双指针

// 题意理解：这道题要理解的关键是，这个题目要做的是分区操作，而不是排序操作
// 在题目给的例子中，小于target的值是1,2,2；那么他们应该排在链表的左边，并且保持顺序
// 4, 3, 5这样的先后顺序不能变

/** 解题技巧这个题目的解法是双指针，并且需要通过哨兵节点
 * 具体做法是线性扫描：
 * 定义两个头结点 before,after.
 * before,after，分别存储两个部分对应的链表。
 * 然后遍历原链表，对于每个节点，如果小于 xx，则插入 before 链表的结尾；否则，插入 after 链表的结尾。
 * 最后将 afterafter 链表插入 beforebefore 链表的结尾。
 *
 * 时间复杂度分析：原链表只遍历一次，所以时间复杂度是 O(n)O(n)
 * https://www.youtube.com/watch?v=72fBK4q0qxo&t=49s&ab_channel=basketwangCoding
 */
public class Solution extends BaseSolution {
    public ListNode partition(ListNode head, int x) {
        //dummy heads of the 1st and 2nd queues
        ListNode dummy1 = new ListNode(0);// 存放小于x的节点
        ListNode dummy2 = new ListNode(0);// 存放大于x的节点

        //current tails of the two queues
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;

        // 对于节点的指向问题，周末需要抽空花大量的时间练习
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }

        //important! avoid cycle in linked list. otherwise u will get TLE.
        curr2.next = null;
        // 将小于x的链表的最后一个节点连接到大于x的链表的第一个节点
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
