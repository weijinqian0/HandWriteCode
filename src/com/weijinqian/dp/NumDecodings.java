package com.weijinqian.dp;

public class NumDecodings {
    /**
     * 91. 解码方法
     * 问解码的方法有多少种
     * 其实就两种情况，考虑前面一位，不考虑前面一位
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            int pre1 = Integer.parseInt(s.substring(i - 2, i));
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
                if (s.charAt(i - 2) != '0' && pre1 <= 26 && pre1 > 10) {
                    dp[i] += dp[i - 2];
                }
            } else {
                if (s.charAt(i - 2) != '0' && pre1 <= 26) {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            }

        }
        return dp[len];
    }
}
