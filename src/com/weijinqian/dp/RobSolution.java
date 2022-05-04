package com.weijinqian.dp;

import java.util.Arrays;

public class RobSolution {

    int[] memory;

    /**
     * 一排的情况
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        memory = new int[nums.length];
        Arrays.fill(memory, -1);
        return dp(nums, 0);
    }

    public int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memory[start] != -1) {
            return memory[start];
        }
        int res = Math.max(dp(nums, start + 1), dp(nums, start + 2) + nums[start]);
        memory[start] = res;
        return res;
    }

    /**
     * dp算法
     * @param nums
     * @return
     */
    public int robDp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
