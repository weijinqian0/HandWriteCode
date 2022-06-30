package com.weijinqian.dp;

public class MaxSubArray {

    /**
     * 最大子数组和
     * dp的定义为以i结尾的最大子数组和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= len; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;

    }

}
