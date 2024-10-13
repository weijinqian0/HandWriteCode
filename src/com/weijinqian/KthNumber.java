package com.weijinqian;

import java.util.PriorityQueue;

public class KthNumber {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int size = 0; //堆的大小
        for (int i = 0; i < nums.length; i++) {
            if (size < k) { //堆的大小 < K
                size++;
                minHeap.add(nums[i]);
            } else {//堆的大小 >= K
                if (minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.add(nums[i]); //放入比较大的元素
                }
            }
        }
        return minHeap.poll();
    }


}
