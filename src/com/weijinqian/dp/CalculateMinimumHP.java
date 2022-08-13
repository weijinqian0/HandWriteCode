package com.weijinqian.dp;

import java.util.Arrays;

public class CalculateMinimumHP {

    /**
     * 174. 地下城游戏
     * 这里面其实要计算的是到右下角的所有路径中的体力最小值
     * 做错了，因为没有分割好子问题
     * 这里的假设任务当前的最小值等于上个路径的最小值，所以错了
     * 不满足无后效性
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        // 转化思路，将最小体力转化为计算路径上的最小负值+1
        // dp的定义就为到当前位置的最大体力，因而需要两个数组，一个是当前路径的最小负值，当前路径下的体力
        int[][] dp = new int[m][n];
        int[][] hp = new int[m][n];
        hp[0][0] = dungeon[0][0];
        dp[0][0] = Math.min(dungeon[0][0], 0);
        for (int i = 1; i < m; i++) {
            hp[i][0] = hp[i - 1][0] + dungeon[i][0];
            if (hp[i][0] >= 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = Math.min(dp[i - 1][0], hp[i][0]);
            }
        }
        for (int i = 1; i < n; i++) {
            hp[0][i] = hp[0][i - 1] + dungeon[0][i];
            if (hp[0][i] >= 0) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = Math.min(dp[0][i - 1], hp[0][i]);
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(Math.min(dp[i - 1][j], hp[i - 1][j] + dungeon[i][j]), Math.min(dp[i][j - 1], hp[i][j - 1] + dungeon[i][j]));
                hp[i][j] = (Math.min(dp[i - 1][j], hp[i - 1][j] + dungeon[i][j]) > Math.min(dp[i][j - 1], hp[i][j - 1] + dungeon[i][j])
                        ? hp[i - 1][j] : hp[i][j - 1]) + dungeon[i][j];
            }
        }
        return 1 - dp[m - 1][n - 1];

    }

    /**
     * 官方题解，之前的解法不满足无后效性，因此使用倒序遍历的情况
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP1(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
