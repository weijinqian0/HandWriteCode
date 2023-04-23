package com.weijinqian.second.dp;

import java.util.Arrays;

public class CalculateMinimumHP {

    /**
     * 174. 地下城游戏
     * 无后效性：某阶段的状态一旦确定，就和此前的决策和状态无关了
     * 因为这里面前向访问的时候，需要计算当前剩余的体力，才能决定之前的选择，
     * 所以前向遍历无后效性
     *
     * {{-2,-3,3},{-5,-10,1},{10,30,-5}};
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // 到当前位置所需要的最小体力
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            dp[m][i] = Integer.MAX_VALUE;
        }
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (dungeon[i][j] < 0) {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];
                } else {
//                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]);
                    if (dungeon[i][j] < Math.min(dp[i][j + 1], dp[i + 1][j])) {
                        dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return dp[0][0];

    }
}
