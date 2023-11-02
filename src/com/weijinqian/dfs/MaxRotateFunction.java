package com.weijinqian.dfs;

import java.util.Map;

public class MaxRotateFunction {
    /**
     * 396. 旋转函数
     * 这个题目硬生生的看出了规律，我也是醉了
     * 给定一个长度为 n 的整数数组 nums 。
     *
     * 假设 arrk 是数组 nums 顺时针旋转 k 个位置后的数组，我们定义 nums 的 旋转函数  F 为：
     *
     * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
     * 返回 F(0), F(1), ..., F(n-1)中的最大值 。
     *
     * 生成的测试用例让答案符合 32 位 整数。
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
