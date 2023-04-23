package com.weijinqian.second.dp;

/**
 * 最长回文子序列
 * 最长回文子串
 * 以最小的插入次数构造回文串
 */
public class LongestPalindromeSub {

    /**
     * 最长回文子序列
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


    /**
     * 最长回文子数组
     * 重点在于标识出为true的位置
     * dp的含义为下表为i和j的字符串是回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindromeSubArray(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxRes = 1;
        int maxi = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] || (j - i + 1) <= 2;
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && (j - i + 1) > maxRes) {
                    maxRes = j - i + 1;
                    maxi = i;
                }
            }
        }
        return s.substring(maxi, maxRes);
    }

    /**
     * 1312. 让字符串成为回文串的最少插入次数
     *
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
