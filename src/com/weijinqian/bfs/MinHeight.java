package com.weijinqian.bfs;

import com.weijinqian.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinHeight {
    /**
     * 二叉树的最小高度
     * @param root
     * @return
     */
    public int minHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int minHeight = 0;
        while (queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.poll();
                // 注意这里需要判断一下
                if (tmp.left == null && tmp.right == null) {
                    return minHeight;
                }
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            minHeight++;
        }
        return minHeight;
    }
}
