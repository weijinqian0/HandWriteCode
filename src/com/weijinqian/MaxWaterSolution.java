package com.weijinqian;

public class MaxWaterSolution {
    /**
     * 能容纳最大的水量
     *
     * @param arr
     * @return
     */
    public long maxWater(int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        lmax[0] = arr[0];
        rmax[len - 1] = arr[len - 1];
        for (int i = 1; i < len - 1; i++) {
            lmax[i] = Math.max(lmax[i - 1], arr[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i]);
        }

        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(lmax[i], rmax[i]) - arr[i];
        }
        return ans;
    }
}
