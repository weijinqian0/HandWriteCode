package com.weijinqian;

public class HasSubtreeSolution {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }
        if (root1 == null) {
            return false;
        }
        return contains(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    public boolean contains(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return contains(root1.left, root2.left) && contains(root1.right, root2.right);
    }
}
