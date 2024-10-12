package com.weijinqian.other;

import com.weijinqian.ListNode;

public class QuickSort {

    /**
     * 数组快排
     *
     * @param array
     * @param low
     * @param high
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(array, low, high);
        quickSort(array, low, index - 1);
        quickSort(array, index + 1, high);

    }

    /**
     * 划分函数
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] array, int left, int right) {
        int len = array.length;
        if (left < 0 || right > len) {
            return -1;
        }
        int mid = array[right];
        int start = left;
        for (int i = start; i < right; i++) {
            if (array[i] < mid) {
                if (i != start) {
                    swapArray(array, i, start);
                }
                start++;
            }
        }
        swapArray(array, start, right);
        return start;
    }

    private static void swapArray(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
