package com.weijinqian.dfs;

import com.weijinqian.TreeNode;

public class LowestCommonAncestorSolution {

    /**
     * NC102 在二叉树中找到两个节点的最近公共祖先
     *
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        TreeNode res = lowestCommonAncestor1(root, o1, o2);
        if (res == null) {
            return -1;
        }
        return res.val;

    }

    private TreeNode lowestCommonAncestor1(TreeNode root, int o1, int o2) {
        if (root == null) {
            return null;
        }
        if (root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, o1, o2);
        TreeNode right = lowestCommonAncestor1(root.right, o1, o2);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }
}
