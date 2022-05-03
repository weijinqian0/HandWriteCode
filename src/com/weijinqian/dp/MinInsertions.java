package com.weijinqian.dp;

public class MinInsertions {
    /**
     * 以最小插入次数构造回文串
     *
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
//        dp[i][j]=dp[i+1][j-1] 依赖于下方和左边，因此j需要从左到右，i从下到上
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][len - 1];
    }
}
