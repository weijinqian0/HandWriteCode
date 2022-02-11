package com.weijinqian;

public class FindGreatestSumOfSubArray {

    /**
     * NC19 连续子数组的最大和
     * @param array
     * @return
     */
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int len = array.length;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i - 1], array[i - 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
