package com.weijinqian.dp;

public class IntegerBreak {

    /**
     * 343. 整数拆分
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 拆或者不拆
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }
}
