package com.weijinqian.dfs;

import com.weijinqian.ListNode;

public class MergeSortSolution {
    ListNode pHead = null;
    ListNode pCur = null;

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        Merge1(list1, list2);
        return pHead;
    }

    private void Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            pCur.next = list2;
            return;
        }
        if (list2 == null) {
            pCur.next = list1;
            return;
        }

        if (list1.val < list2.val) {
            if (pHead == null) {
                pHead = list1;
                pCur = pHead;
            } else {
                pCur.next = list1;
                pCur = list1;
            }
            Merge1(list1.next, list2);
        } else {
            if (pHead == null) {
                pHead = list2;
                pCur = pHead;
            } else {
                pCur.next = list2;
                pCur = list2;
            }
            Merge1(list1, list2.next);
        }

    }
}
