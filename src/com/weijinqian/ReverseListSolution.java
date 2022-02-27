package com.weijinqian;

// 反转链表
public class ReverseListSolution {
    /**
     * // NC78 反转链表
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head1 = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return head1;
    }

    /**
     * NC50 链表中的节点每k个一组翻转
     * 其本质应该是一样的，就是每k个出栈一次
     *
     * @param head
     * @param
     * @return
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;
        while (cur != tail) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverse(a, b);
        // 反转之和，a变成了最后一个，b变成下一个的头
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转固定位置的list
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode cur = head;
        ListNode a = null;
        ListNode b = null;
        ListNode pre = null;
        while (cur != null) {
            if (i == m - 1) {
                pre = cur;
            }
            if (i == m) {
                a = cur;
            }
            if (i == n) {
                b = cur;
            }
            cur = cur.next;
            i++;
        }
        if (a == null || b == null || a == b) {
            return head;
        }

        ListNode tail = b.next;
        ListNode newHead = reverse(a, tail);
        a.next = tail;
        if(pre==null){
            return newHead;
        }
        pre.next = newHead;
        return head;
    }


}
