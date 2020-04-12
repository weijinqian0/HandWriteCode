package com.weijinqian;

public class EntryNodeOfLoopSolution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        int circleLen = 0;
        ListNode pIdx1 = pHead;
        ListNode pIdx2 = pHead.next;

        while (pIdx1 != pIdx2) {
            if (pIdx1 != null) {
                pIdx1 = pIdx1.next;
            } else {
                return null;
            }
            if (pIdx2 != null && pIdx2.next != null) {
                pIdx2 = pIdx2.next.next;
            } else {
                return null;
            }
            circleLen++;
        }

        pIdx2 = pHead;
        while (circleLen >= 0) {
            pIdx2 = pIdx2.next;
            circleLen--;
        }

        pIdx1 = pHead;
        while (pIdx2 != pIdx1) {
            pIdx1 = pIdx1.next;
            pIdx2 = pIdx2.next;
        }

        return pIdx1;
    }
}
