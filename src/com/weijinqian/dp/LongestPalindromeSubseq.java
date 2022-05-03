package com.weijinqian.dp;

public class LongestPalindromeSubseq {
    /**
     * 最长回文子序列
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
//        因为依赖于左、下方的位置，所以得先把左边的位置和下方的位置填充一下
//        所以遍历的时候，需要已经存在左边的位置，所以j从左到右
//        需要存在下方的位置，所以i需要从下往上。
//        dp[i][j] = dp[i+1][j-1]
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
