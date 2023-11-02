package com.weijinqian.dp;

public class LongestCommonSubsequence {

    /**
     * 最长相同子序列
     * @param str1
     * @param str2
     * @return
     */
    public int longestCommonSubsequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return 0;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= len1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[len1][len2];
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
