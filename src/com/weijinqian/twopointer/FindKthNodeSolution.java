package com.weijinqian.twopointer;

import com.weijinqian.ListNode;

public class FindKthNodeSolution {
    /**
     * 通过两个指针间隔k-1个距离来做
     *
     * @param head
     * @param k
     * @return
     */
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


    private int curIdx = 0;
    private ListNode res = null;

    /**
     * 通过递归的方式来做，相当于后序遍历
     *
     * @param head
     * @param k
     * @return
     */
    public void FindKthToTail1(ListNode head, int k) {
        if (head == null) {
            return;
        }
        if (k <= 0) {
            return;
        }

        if (curIdx == k) {
            res = head;
            return;
        }
        FindKthToTail1(head.next, k);
        curIdx++;

    }
}
