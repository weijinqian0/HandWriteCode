package com.weijinqian.dfs;

public class CanPartition {
    /**
     * 416. 分割等和子集
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        // 只要有一种方案，是的数据能够恰好达到和的一半，那么就是对的
        sum = sum / 2;
        // 就变成了0 1背包问题
        boolean[][] dp = new boolean[len + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[len][sum];

    }
}
