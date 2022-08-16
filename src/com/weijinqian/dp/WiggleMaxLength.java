package com.weijinqian.dp;

public class WiggleMaxLength {

    /**
     * 376. 摆动序列
     * 求最长的摆动序列，其实就是拿到差值的数组，之后再处理
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] deviation = new int[len - 1];
        for (int i = 1; i < len; i++) {
            deviation[i - 1] = nums[i] - nums[i - 1];
        }
        return maxLen(deviation) + 1;
    }

    public int maxLen(int[] nums) {
        int len = nums.length;
        // 以i为结尾的最长摆动序列
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            if (nums[i - 1] != 0) {
                dp[i] = 1;
            }
        }
        int maxValue = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                if (nums[i - 1] < 0 && nums[j - 1] > 0 || nums[i - 1] > 0 && nums[j - 1] < 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] > maxValue) {
                    maxValue = dp[i];
                }
            }
        }
        return maxValue;
    }
}
