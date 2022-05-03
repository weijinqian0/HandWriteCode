package com.weijinqian.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长递增子序列
 */
public class LengthOfLIS {

    /**
     * 二维递增子序列：信封嵌套问题
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[1] - o2[1];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    /**
     * 最长递增子序列
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private Map<Integer, Integer> map = new HashMap<>();

    public int lengthOfLISMem(int[] nums, int idx) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (idx == 0) {
            return 1;
        }
        if (map.containsKey(idx)) {
            return map.get(idx);
        }

        int res = 0;
        for (int i = 0; i < idx; i++) {
            if (nums[i] < nums[idx]) {
                res = Math.max(res, lengthOfLISMem(nums, i));
            }
        }
        if (!map.containsKey(idx)) {
            map.put(idx, res);
        }
        return res;
    }


}
