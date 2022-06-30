package com.weijinqian.dp;

import java.util.Arrays;

public class RobCircleSolution {

    /**
     * 圆形链排列的情况
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    /**
     * 间隔偷，所能获得最大利润
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int robRange1(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 当前位置所能获得的最大利润
        int[] dp = new int[end - start + 1];
        dp[start] = nums[start];
        dp[start + 1] = nums[start + 1];
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }

    public int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
