package com.tags.list.deleteDuplicates;

import test.BaseSolution;
import test.ListNode;

public class Solution extends BaseSolution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode p = head;
        while(p != null && p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;

    }
}
