package com.weijinqian.second.dp;

public class LIS {
    /**
     * 最长递增子序列
     * dp 以当前位置结尾的最长子序列
     * [1,2 3,3,4]
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                }
            }
        }
        return maxLen;
    }
}
