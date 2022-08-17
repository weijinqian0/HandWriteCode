package com.weijinqian.dfs;

import java.util.Map;

public class MaxRotateFunction {
    /**
     * 396. 旋转函数
     * 这个题目硬生生的看出了规律，我也是醉了
     *
     * @param nums
     * @return
     */
    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            dp[0] += i * nums[i];
            sum += nums[i];
        }
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + sum - nums[len - i] * len;
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
