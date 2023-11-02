package com.weijinqian.dp;

import java.util.HashMap;

public class CoinChange {
    /**
     * 硬币兑换
     * 最小的硬币数量
     *
     * @param coins
     * @param amount
     * @return
     */
    public int getCoinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        // 当前金额下的最小的硬币数量
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    continue;
                }
                // 为啥是dp[i] 和 dp[i-coins[j]] + 1
                // 当前金额下的最小硬币数量
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount];

    }

    /**
     * 通过记忆的方法来获取答案
     * 那我怎么进行全部遍历呢？
     * 使用bfs，回溯法
     *
     * @param coins
     * @param amount
     * @return
     */
    private HashMap<Integer, Integer> memory = new HashMap<>();

    public int getCoinChangeMem(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return 0;
        }
        if (amount <= 0) {
            return 0;
        }
        if (memory.containsKey(amount)) {
            return memory.get(amount);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount < coins[i]) {
                continue;
            }
            ans = Math.min(ans, getCoinChangeMem(coins, amount - coins[i]) + 1);

        }
        if (!memory.containsKey(ans)) {
            memory.put(amount, ans);
        }
        return ans;

    }

    /**
     * 322. 零钱兑换
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     *
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     *
     * 示例 1：
     *
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     *
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：coins = [1], amount = 0
     * 输出：0
     * 经过验证
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = amount + 1;
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = amount + 1;
            }
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[len][amount] == amount + 1 ? -1 : dp[len][amount];

    }
}
