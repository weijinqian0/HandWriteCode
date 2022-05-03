package com.weijinqian.dp;

public class Knapsack {
    /**
     * 0-1 背包问题
     *
     * @param W   背包的容量
     * @param wt  石头的重量
     * @param val 石头的价值
     * @return
     */
    public int knapsack(int W, int[] wt, int[] val) {
        if (wt == null || val == null) {
            return 0;
        }
        if (wt.length != val.length) {
            return 0;
        }
        int N = val.length;
        int[][] dp = new int[N + 1][W + 1];
//        dp的含义，对于前i个物品，当前背包的容量为W，可以装下的最大价值是dp[i][W]
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= wt[i - 1]) {
                    // 如果装了第i个物品，就要寻求剩余重量下限制下的最大价值，加上当前的价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }
}
