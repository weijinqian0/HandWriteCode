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
//        按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
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
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < length; i++) {
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


    /**
     * 动态规划+二分查找 最长递增子序列
     * Dynamic programming + Dichotomy
     * 这里dp的定义是以只有i个元素的最长递增子序列，里面的元素是对应的最后一个元素
     * 如果后面的
     *
     * @param nums
     * @return
     */
    public int lengthOfLISDic(int[] nums) {
        int[] dp = new int[nums.length];// dp[i] 的值代表 子序列的长度 为 i 时，此序列尾部元素的值。
        int max = 0;// 最长子序列的长度
        for (int num : nums) {
//            left指向小于target的那一部分元素或者右边部分第一个元素
//            right 指向右侧大于等于target的
            int left = 0, right = max;
            while (left < right) {
                int m = (right + left) / 2;
                if (dp[m] < num)
                    left = m + 1;
                else
                    right = m;
            }
            dp[left] = num; // 二分法找到大于num的第一个值覆盖
            max = Math.max(max, left + 1);// 更新最大长度
        }
        return max;
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
