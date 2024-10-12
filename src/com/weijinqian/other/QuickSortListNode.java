package com.weijinqian.other;

import com.weijinqian.ListNode;

public class QuickSortListNode {

    /**
     * 链表快排
     * @param begin
     * @param end
     */
    public static void quickSort(ListNode begin, ListNode end) {
        if (begin == null || begin == end)
            return;
        ListNode index = partition(begin, end);
        quickSort(begin, index);
        quickSort(index.next, end);

    }

    /**
     * 划分函数，以头结点值为基准元素进行划分
     *
     * @param begin
     * @param end
     * @return
     */
    public static ListNode partition(ListNode begin, ListNode end) {
        if (begin == null || begin == end){
            return begin;
        }
        int val = begin.val; //基准元素
        ListNode index = begin, cur = begin.next;
        while (cur != end) {
            if (cur.val < val) { //交换
                index = index.next;
                int tmp = cur.val;
                cur.val = index.val;
                index.val = tmp;
            }
            cur = cur.next;
        }
        begin.val = index.val;
        index.val = val;
        return index;

    }
}
