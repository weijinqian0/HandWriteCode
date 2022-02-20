package com.weijinqian;

import java.util.ArrayList;
import java.util.List;

public class FindPathSolution {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        DFS(root, target, 0, new ArrayList<>());
        return res;
    }

    /**
     * 深度优先遍历
     */
    private void DFS(TreeNode root, int target, int sum, List<Integer> tmp) {
        if (root == null) {
            return;
        }

        sum += root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == sum) {
                res.add(new ArrayList<>(tmp));
            }
        }
        DFS(root.left, target, sum, tmp);
        DFS(root.right, target, sum, tmp);
        tmp.remove(tmp.size() - 1);
    }

    /**
     * 深度优先遍历
     */
    private void DFS1(TreeNode root, int target, int sum, List<Integer> tmp) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (target == sum) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }

        tmp.add(root.val);
        DFS(root.left, target, sum + root.val, tmp);
        DFS(root.right, target, sum + root.val, tmp);
        tmp.remove(tmp.size() - 1);
    }

}
