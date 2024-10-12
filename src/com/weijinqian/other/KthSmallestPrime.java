package com.weijinqian.other;

import java.util.PriorityQueue;

public class KthSmallestPrime {

    /**
     * https://leetcode.com/problems/k-th-smallest-prime-fraction/
     * 找到第k小的素数分数
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return null;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> arr[a[0]] * arr[b[1]] - arr[a[1]] * arr[b[0]]);
        int n = arr.length;

        // 单调递减
        for (int i = 1; i < n; i++) {
            pq.add(new int[]{0, i});
        }

        while(k>0) {
            int[] t = pq.poll();
            // 分子加1代表
            pq.add(new int[]{t[0] + 1, t[1]});
            k--;
            if(k==0) return new int[]{arr[t[0]], arr[t[1]]};
        }
        return null;

    }
}
