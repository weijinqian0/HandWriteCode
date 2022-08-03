package com.weijinqian.dp;

/**
 * 32. 最长有效括号
 */
public class LongestValidParentheses {

    /**
     * 这个dp算法竟然超时
     * 就是将dp拆解清楚，包含两个部分，包含关系和并列关系
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 总共两种关系，包含和并列
        int len = s.length();
        // 以i开头，j结尾的最长括号
        int[][] dp = new int[len][len];
        int max_res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                int x = j;
                int y = j + i;
                if (s.charAt(x) == '(' && s.charAt(y) == ')') {
                    if (dp[x + 1][y - 1] != 0 || y == x + 1) {
                        dp[x][y] = 2 + dp[x + 1][y - 1];
                    }
                }
                for (int k = x + 1; k < y; k++) {
                    if (dp[x][k] != 0 && dp[k + 1][y] != 0) {
                        dp[x][y] = Math.max(dp[x][y], dp[x][k] + dp[k + 1][y]);
                    }
                }
                if (dp[x][y] > max_res) {
                    max_res = dp[x][y];
                }
            }
        }
        return max_res;
    }

    /**
     * 这种方法，直接建模当前下标最长
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 总共两种关系，包含和并列
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
