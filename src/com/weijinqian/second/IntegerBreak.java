package com.weijinqian.second;

public class IntegerBreak {

    /**
     * 343. 整数拆分
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // 最后一个之前每个最小值都是自己
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }
        dp[n] = n - 1;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * j);
            }
        }
        return dp[n];
    }
}
