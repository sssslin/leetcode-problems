package com.tags.list.addTwoNumbers;

import test.BaseSolution;
import test.ListNode;

/**
 * 这题有几个要注意的地方
 * 1、如果测试用例中，存在0的情况，该如何处理
 * 2、如果两个节点对应的数字加起来大于10的情况,要考虑进位
 * 3、长度不一样的两条链表，要好好处理
 * 4、结果比输入的长度更长
 */
public class Solution extends BaseSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode dummy = new ListNode(0);
        // 通过一个新增一个起始为0的节点作为辅助，最终返回一个
        ListNode tail = dummy;
        // 边界条件：当两个节点都为空，且没有进位的情况下，退出循环
        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                // 如果有进位，则会通过sum相加
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                // 如果有进位，则会通过sum相加
                sum += l2.val;
                l2 = l2.next;
            }

            // 当前位数字
            tail.next = new ListNode(sum % 10);
            // 是否需要进位
            sum /= 10;
            tail = tail.next;
        }
        return dummy.next;
    }
}
