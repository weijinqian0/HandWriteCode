package com.weijinqian.bfs;

import java.util.*;

class Node {
    public List<Node> adj;

    public Node(List<Node> adj) {
        this.adj = adj;
    }
}

public class BFS {

    /**
     * 计算从起点start到终点target的最短距离
     * @param start
     * @param target
     * @return
     */
    public int BFS(Node start, Node target) {
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (queue.size() != 0) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Node cur = queue.poll();
                if (cur == target) {
                    return step;
                }
                for (Node x : cur.adj) {
                    if (!visited.contains(x)) {
                        queue.offer(x);
                        visited.add(x);
                    }
                }
            }
            step++;
        }
        return step;
    }
}
