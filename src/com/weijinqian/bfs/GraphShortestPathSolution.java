package com.weijinqian.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * NC158 单源最短路
 */
public class GraphShortestPathSolution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n     int 顶点数
     * @param m     int 边数
     * @param graph int二维数组 一维3个数据，表示顶点到另外一个顶点的边长度是多少​
     * @return int
     */
    public int findShortestPath(int n, int m, int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return 0;
        }
        Map<Integer, Map<Integer, Integer>> graphMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graphMap.put(i + 1, new HashMap<>());
        }
        for (int i = 0; i < graph.length; i++) {
            int node1 = graph[i][0];
            int node2 = graph[i][1];
            int weight = graph[i][2];
            graphMap.get(node1).put(node2, Math.min(weight, graphMap.get(node1).getOrDefault(node2, Integer.MAX_VALUE)));
        }
//        使用bfs的方式来做，也就是dijkstra方法，这里层的概念就是所有节点
        int[] minDistance = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            minDistance[i] = Integer.MAX_VALUE;
        }
        minDistance[0] = 0;
        minDistance[1] = 0;
        for (int i = 1; i <= n; i++) {
            if (minDistance[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int j : graphMap.get(i).keySet()) {
                int weight = graphMap.get(i).get(j);
                if (minDistance[i] + weight < minDistance[j]) {
                    minDistance[j] = minDistance[i] + weight;
                }

            }
        }
        return minDistance[n] == Integer.MAX_VALUE ? -1 : minDistance[n];
    }
}
