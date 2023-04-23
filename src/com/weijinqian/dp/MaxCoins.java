package com.weijinqian.dp;

public class MaxCoins {

    /**
     * https://blog.csdn.net/I12XXXXXLbull/article/details/107436503
     * 戳气球
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] points = new int[len + 2];
        points[0] = 1;
        points[len + 1] = 1;
        for (int i = 0; i < len; i++) {
            points[i + 1] = nums[i];
        }
        int[][] dp = new int[len + 2][len + 2];
        for (int i = len; i >= 0; i--) {
            for (int j = i + 1; j < len + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]);
                }
            }
        }
        return dp[0][len + 1];
    }
}
