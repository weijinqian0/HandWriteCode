package com.weijinqian.dfs;

public class CanCross {
    /**
     * 403. 青蛙过河
     *
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0 || stones.length == 1) {
            return true;
        }
        int len = stones.length;
        // 加一个状态，表示青蛙跳到当前位置的步长。因为加了一个状态，所以使用二维的数组。最长的步长为len
        // i j 代表第i快stone 跳j步
        boolean[][] dp = new boolean[len][len];
        dp[0][0] = true;

        for (int i = 1; i < len; i++) {
            // 表示之前的石头
            for (int j = 0; j < i; j++) {
                int k = stones[i] - stones[j];
                if (k <= i) {
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || k < (len - 1) && dp[j][k + 1];
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (dp[len - 1][i]) {
                return true;
            }
        }
        return false;

    }
}
