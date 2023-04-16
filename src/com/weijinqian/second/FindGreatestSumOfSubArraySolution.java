package com.weijinqian.second;

public class FindGreatestSumOfSubArraySolution {

    /**
     * 找到最大连续子数组的和
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int maxRes = array[0];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i - 1], array[i - 1]);
            maxRes = Math.max(maxRes, dp[i]);
        }
        return maxRes;
    }

}
