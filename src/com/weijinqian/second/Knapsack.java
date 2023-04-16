package com.weijinqian.second;

public class Knapsack {

    /**
     * 0-1 背包问题 放入or不放入，使得价值最大化
     *
     * @param W   背包的容量
     * @param wt  石头的重量
     * @param val 石头的价值
     * @return
     */
    public int knapsack(int W, int[] wt, int[] val) {

        int n = wt.length;
        // 到了多少重量的最大价值
        int[] dp = new int[W + 1];
        for (int j = 0; j < n; j++) {
            // 这里需要倒序，为啥呢？因为如果正序，比如j=0，会放多次并叠加到里面
            for (int i = W; i >= 1; i++) {
                if (i >= wt[j]) {
                    dp[i] = Math.max(dp[i - wt[j]] + val[j], dp[i]);
                }
            }
        }
        return dp[W];

    }

    /**
     * 0-1 背包问题
     * 写一个二维矩阵的，每次用于表示当前这个物品是否放入
     * dp的定义：遍历到第i个物品，所有背包容量，所能容纳的最大价值
     *
     * @param W   背包的容量
     * @param wt  石头的重量
     * @param val 石头的价值
     * @return
     */
    public int knapsack1(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (j > wt[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    /**
     * 完全背包问题
     * 写一个二维矩阵的，每次用于表示当前这个物品是否放入
     * 区别在于，物品可重复，这就需要当前的物品可以反复使用，这样就将dp[i-1]变为dp[i]
     *
     * @param W   背包的容量
     * @param wt  石头的重量
     * @param val 石头的价值
     * @return
     */
    public int knapsack2(int W, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (j > wt[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    /**
     * 完全背包问题
     * 写一个一维矩阵的，每次用于表示当前这个物品是否放入
     *
     * @param W   背包的容量
     * @param wt  石头的重量
     * @param val 石头的价值
     * @return
     */
    public int knapsack3(int W, int[] wt, int[] val) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < wt.length; i++) {
            for (int j = 1; j <= W; j++) {
                if (j > wt[i]) {
                    dp[j] = Math.max(dp[j - wt[i]] + val[i], dp[j]);
                }
            }
        }
        return dp[W];
    }

    /**
     * 子集背包问题
     * 其实就是01问题，每个数字只能取一次
     * 一个字符数组能否完全分为和相等的两个数组，这里有要求数组的数字都是正整数，所以就转化为了0-1背包问题
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int part = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][part + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= part; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][part];
    }

    /**
     * 完全背包问题，不重复的方案
     * 硬币有多少种方案
     * 5  1 2 3
     *
     * @param amount
     * @param coins
     * @return
     */
    public int coinChanges(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        // 啥也不放也是一种方案
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j > coins[i - 1]) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][amount];
    }

    /**
     * 完全背包问题，去过重的方案
     * https://blog.csdn.net/qq_41605114/article/details/106086262
     * @param amount
     * @param coins
     * @return
     */
    public int coinChanges3(int amount, int[] coins) {
        int N = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }


    /**
     * 完全背包问题，会有重复的方案累加
     * 考虑顺序，需要将其物品放到内循环，二维矩阵是一列一列计算的，这时候，加方案的时候会考虑顺序，但是Math.max
     *
     * @param amount
     * @param coins
     * @return
     */
    public int coinChanges1(int amount, int[] coins) {
        int N = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }

    /**
     * 求能兑换amount的最小硬币数
     *
     * @param amount
     * @param coins
     * @return
     */
    public int coinChanges2(int amount, int[] coins) {
        int N = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount];
    }
}
