package com.weijinqian.second.dp;

public class LCSubsequence {
    /**
     * 最长公共子序列
     * abc ac
     * abc a
     * ab a
     * 1 1 1
     * 1 1 2
     * @param s1
     * @param s2
     * @return
     */
    public int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 这里是一定小于上面的，为啥？因为最长的子序列一定是s[i-1],or s[j-1]的子序列，最大就是s[i-1] 和 s[j-1] +1
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];

    }

    /**
     * 最长公共子串，中间需要断开，这里的dp需要定义为以当前结尾的子串的最长长度
     * abc ab
     * 1 0 0
     * 0 2 0
     *
     * @param s1
     * @param s2
     * @return
     */
    public int lcs1(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        int maxLen = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                }
            }
        }
        return maxLen;
    }
}
