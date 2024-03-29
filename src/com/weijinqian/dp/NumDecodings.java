package com.weijinqian.dp;

public class NumDecodings {
    /**
     * 91. 解码方法
     * 问解码的方法有多少种
     * 其实就两种情况，考虑前面一位，不考虑前面一位
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     *
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
     *
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     *
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
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
