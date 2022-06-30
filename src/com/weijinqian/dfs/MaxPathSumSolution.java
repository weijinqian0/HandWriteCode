package com.weijinqian.dfs;

import com.weijinqian.TreeNode;

//NC6 二叉树中的最大路径和
public class MaxPathSumSolution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int priceNewPath = leftGain + rightGain + root.val;
        if (priceNewPath > maxSum) {
            maxSum = priceNewPath;
        }
        return root.val + Math.max(leftGain, rightGain);
    }
}
