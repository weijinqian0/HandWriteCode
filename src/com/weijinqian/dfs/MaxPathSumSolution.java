package com.weijinqian.dfs;

import com.weijinqian.TreeNode;

//NC6 二叉树中的最大路径和

public class MaxPathSumSolution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 二叉树里面的路径被定义为:从该树的任意节点出发，经过父=>子或者子=>父的连接，达到任意节点的序列。
     *
     * 注意:
     *
     * 1.同一个节点在一条二叉树路径里中最多出现一次
     *
     * 2.一条路径至少包含一个节点，且不一定经过根节点
     *
     * 给定一个二叉树的根节点root，请你计算它的最大路径和
     * @param root
     * @return
     */
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
