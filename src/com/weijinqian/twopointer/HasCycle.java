package com.weijinqian.twopointer;

import com.weijinqian.ListNode;

public class HasCycle {
    public boolean hasCycle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 找到环的开始节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 找到链表的中间位置
     *
     * @param head
     * @return
     */
    public ListNode detectMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 寻找倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode detectKNode(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
