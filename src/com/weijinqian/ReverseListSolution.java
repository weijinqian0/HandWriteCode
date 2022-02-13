package com.weijinqian;

// NC78 反转链表
public class ReverseListSolution {
    public ListNode ReverseList(ListNode head) {
        if(head==null|| head.next==null){
            return head;
        }
        ListNode head1 = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head1;
    }
}
