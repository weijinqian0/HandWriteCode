package com.weijinqian.dp;

import java.util.HashMap;
import java.util.Map;

public class NumberOfArithmeticSlices {

    /**
     * 413. 等差数列划分
     * 求等差子数组的个数
     * 有差作差
     * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
     *
     * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
     * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
     *
     * 子数组 是数组中的一个连续序列。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：3
     * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：0
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

    /**
     * 446. 等差数列划分 II - 子序列
     * 等差子序列的数目
     * 因为还需要维持一个维度表示和上一维的差值
     * // 思路有问题，因为差值有正负，所以使用数组很难表示；
     * // 所以这里使用了Map数组来表示
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices1(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}
