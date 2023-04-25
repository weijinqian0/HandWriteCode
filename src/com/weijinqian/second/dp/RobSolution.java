package com.weijinqian.second.dp;

import com.weijinqian.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class RobSolution {

    /**
     * 198. 打家劫舍
     * 一排的情况进行抢劫，相邻之间不能，求最大能抢的数量
     *
     * @param nums
     * @return
     */
    public int rob_linear(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    /**
     * 213. 打家劫舍 II
     *
     * @param nums
     * @return
     */
    public int rob_circle(int[] nums) {
        int n = nums.length;
        return Math.max(rob_linear(nums, 0, n - 2), rob_linear(nums, 1, n - 1));
    }

    public int rob_linear(int[] nums, int left, int right) {
        int n = right - left + 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[left];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[left + i - 1]);
        }
        return dp[n];
    }

    /**
     * 337. 打家劫舍 III
     * 父 子之间不能相邻打劫
     *
     * @param root
     * @return
     */
    Map<TreeNode, Integer> mem = new HashMap<>();

    public int rob_tree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (mem.containsKey(root)) {
            return mem.get(root);
        }
        int cur = root.val;
        int maxRes = Math.max(rob_tree(root.left) + rob_tree(root.right), cur
                + (root.left == null ? 0 : rob_tree(root.left.left) + rob_tree(root.left.right))
                + (root.right == null ? 0 : rob_tree(root.right.left) + rob_tree(root.right.right))
        );
        mem.put(root, maxRes);
        return maxRes;
    }

    /**
     * 2560. 打家劫舍 IV
     * 看到「最大化最小值」或者「最小化最大值」就要想到二分答案，这是一个固定的套路。
     * 为什么？一般来说，二分的值越大，越能/不能满足要求；二分的值越小，越不能/能满足要求，有单调性，可以二分。
     * https://leetcode.cn/problems/house-robber-iv/solution/er-fen-da-an-dp-by-endlesscheng-m558/
     * 设二分的最大金额为
     * mx
     * mx，定义
     * f
     * [
     * i
     * ]
     * f[i] 表示在前
     * i
     * i 个房屋中窃取金额不超过
     * mx
     * mx 的房屋的最大个数。
     * @param nums
     * @param k
     * @return
     */
    public int minCapability(int[] nums, int k) {
        // left right 是金额，针对每个金额
        int left = 0, right = (int) 1e9;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            int f0 = 0, f1 = 0;
            for (int x : nums)
                if (x > mid) f0 = f1;
                else {
                    int tmp = f1;
                    f1 = Math.max(f1, f0 + 1);
                    f0 = tmp;
                }
            if (f1 >= k) right = mid;
            else left = mid;
        }
        return right;
    }

}
