package com.weijinqian.dfs;

public class NumberOfArithmeticSlices {

    /**
     * 413. 等差数列划分
     * 求等差子数组的个数
     * 有差作差
     *
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1 || nums.length == 2) {
            return 0;
        }
        // 既然是作差的，那我们直接把差算出来。然后看相同差值的个数大于2的次数？
        int len = nums.length;
        int[] gaps = new int[len];
        gaps[0] = 0;
        for (int i = 1; i < len; i++) {
            gaps[i] = nums[i] - nums[i - 1];
        }
        int[] dp = new int[len];
        int res = 0;
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < len; i++) {
            if (gaps[i] == gaps[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
            res += dp[i];
        }
        return res;

    }
}
