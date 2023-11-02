package com.weijinqian.dp;

import java.util.*;

public class SplitArray {

    /**
     * 410. 分割数组的最大值
     * 题意：就是这种切分方法，使得各个分割后的数组的和，在所有方案中的值最小
     * 那就是遍历所有的切分方案呗
     * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
     *
     * 设计一个算法使得这 m 个子数组各自和的最大值最小。
     *
     * 示例 1：
     *
     * 输入：nums = [7,2,5,10,8], m = 2
     * 输出：18
     * 解释：
     * 一共有四种方法将 nums 分割为 2 个子数组。
     * 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
     * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
     * 示例 2：
     *
     * 输入：nums = [1,2,3,4,5], m = 2
     * 输出：9
     * 示例 3：
     *
     * 输入：nums = [1,4,4], m = 3
     * 输出：4
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length < m) {
            return 0;
        }
        List<Integer> copyNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            copyNums.add(nums[i]);
        }
        int[] sub = new int[nums.length + 1];
        sub[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sub[i] = sub[i - 1] + nums[i - 1];
        }
        return DFS(copyNums, m, 1, 0, nums.length, sub);
    }

    Map<String, Integer> memory = new HashMap<>();

    // 加了缓存之后，发现还是超时，此时，我们使用减法替代sum，用来减少累加的耗时
    // 这个算法还是耗时...
    public int DFS(List<Integer> nums, int m, int cur, int begin, int end, int[] sub) {
        String key = begin + "_" + end + "_" + cur;
        if (cur >= m) {
            return sub[end] - sub[begin];
        }
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        // i 代表切分的下标
        int res = Integer.MAX_VALUE;
        for (int i = begin + 1; i < end; i++) {
            res = Math.min(Math.max(sub[i] - sub[begin], DFS(nums, m, cur + 1, i, end, sub)), res);

        }
        memory.put(key, res);
        return res;
    }

    /**
     * dp的版本
     * @param nums
     * @param m
     * @return
     */
    public int splitArray1(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        // j表示段数
        // k 表示前k个数为j-1段
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }

    /**
     * 二分的版本
     * @param nums
     * @param m
     * @return
     */
    public int splitArray2(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 不超过x的子数组个数，判断与m的比较，
     * 如果大于m，则说明：分的数组多了，要放大一些范围
     * 如果小于m，则说明：分的数组少了，要缩小一些范围
     * @param nums
     * @param x
     * @param m
     * @return
     */
    public boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/split-array-largest-sum/solution/fen-ge-shu-zu-de-zui-da-zhi-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
