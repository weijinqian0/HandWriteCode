package com.weijinqian.second.list;

import com.weijinqian.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return cur;
    }
}
