package com.weijinqian.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class EraseOverlapIntervals {

    /**
     * 435. 无重叠区间
     * 先看了贪心算法的题解方法，就先写一个贪心算的题解
     * 贪心算法思想：我们最终要求的是不重复的最大个数。也就是需要去除的最小数量
     * 为啥感觉就是信封问题呢？信封问题转化成了最长子序列的问题
     * 那么这么考虑：就是先按照右侧进行排序，排好序寻找左侧边界最小的那个作为第一个
     * 后面一次这么选择，但是需要注意不要和上一个边界位置重叠
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        int m = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < m; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
            } else {
                res++;
            }
        }
        return res;

    }

    /**
     * dp 算法，这里怎么分割子问题呢？ 还得看下题解
     * 题目等价于选出最多数量的区间，使得他们不重叠, 牛逼
     * 先根据一个端排个序，排好序之后呢？不能直接就变成最长子序列问题，因为这里要根据左右对比来判断状态
     * 代码是对的，但是在leetcode会因为某些case超时
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        int m = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // dp[i]表示以当前i结尾的区间的最大值
        int[] dp = new int[m];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
        }
        return m - max;

    }
}
