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
}
