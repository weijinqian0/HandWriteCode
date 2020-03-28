package com.weijinqian;

public class FindKthNodeSolution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }

        ListNode res = head;
        int idx1 = 1;
        ListNode tmp = head;
        while (idx1 < k) {
            tmp = tmp.next;
            if (tmp == null) {
                return null;
            }
            idx1++;
        }

        while (tmp.next != null) {
            res = res.next;
            tmp = tmp.next;
        }
        return res;
    }
}
