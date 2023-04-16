package com.weijinqian.second;

public class CutCopeSolution {

    /**
     * 割绳子
     * 长度为n，切成m段，使得乘积最大
     * https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
     *
     * @param n
     * @return
     */
    int cuttingRope(int n) {
        int maxRes = 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
            dp[i][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i - k][j - 1] * k, dp[i][j]);
                    maxRes = Math.max(dp[i][j], maxRes);
                }
            }
        }
        return maxRes;
    }

    public int cuttingRope1(int n) {
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
