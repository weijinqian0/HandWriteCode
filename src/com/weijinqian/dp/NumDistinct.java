package com.weijinqian.dp;

public class NumDistinct {
    /**
     * 115. 不同的子序列
     * dp[i][j] 以当前i，j结尾的子序列个数
     * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
     *
     * 示例 1：
     *
     * 输入：s = "rabbbit", t = "rabbit"
     * 输出：3
     * 解释：
     * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
     * rabbbit
     * rabbbit
     * rabbbit
     * 示例 2：
     *
     * 输入：s = "babgbag", t = "bag"
     * 输出：5
     * 解释：
     * 如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
     * babgbag
     * babgbag
     * babgbag
     * babgbag
     * babgbag
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;

        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= i && j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
