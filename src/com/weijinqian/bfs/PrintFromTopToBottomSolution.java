package com.weijinqian.bfs;

import com.weijinqian.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PrintFromTopToBottomSolution {
    ArrayList<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new ArrayDeque<>();

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}
