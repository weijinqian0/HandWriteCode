package com.weijinqian.dfs;

import com.weijinqian.TreeNode;

public class TreeDepthSolution {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

}
