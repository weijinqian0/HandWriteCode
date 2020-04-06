package com.weijinqian;

public class FindFirstCommonNodeSolution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        while (pNode1 != null) {
            pNode1 = pNode1.next;
            len1++;
        }

        while (pNode2 != null) {
            pNode2 = pNode2.next;
            len2++;
        }

        if (len1 > len2) {
            return findCommonNode(pHead1, pHead2, len1 - len2);
        } else {
            return findCommonNode(pHead2, pHead1, len2 - len1);
        }
    }

    /**
     * 找到相等的节点，保证pHead1长度大于pHead2
     *
     * @param pHead1
     * @param pHead2
     * @param diffLen
     * @return
     */
    ListNode findCommonNode(ListNode pHead1, ListNode pHead2, int diffLen) {
        ListNode pCur1 = pHead1;
        while (pCur1 != null && diffLen > 0) {
            pCur1 = pCur1.next;
            diffLen--;
        }

        ListNode pCur2 = pHead2;
        while (pCur1 != null && pCur2 != null) {
            if (pCur1 == pCur2) {
                return pCur1;
            }
            pCur1 = pCur1.next;
            pCur2 = pCur2.next;

        }
        return null;
    }
}
