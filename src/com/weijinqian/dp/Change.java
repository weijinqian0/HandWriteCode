package com.weijinqian.dp;

public class Change {

    /**
     * 完全背包问题，是说一个硬币可以放无数次
     * 0-1背包问题，是说一个硬币只有一种方法，选或者不选
     * 找零钱有多少种方案，不重复
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 这里为啥是i，是因为这里是完全背包问题，0-1则使用i-1
                    // 在当前背包容量下，当前coins数，有多少种方案
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[len][amount];
    }
}
