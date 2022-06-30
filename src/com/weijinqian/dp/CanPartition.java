package com.weijinqian.dp;

public class CanPartition {

    /**
     * 子集背包问题
     * 其实就是01问题，每个数字只能取一次
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        sum = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][sum];
    }
}
