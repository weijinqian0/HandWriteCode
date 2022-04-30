package com.weijinqian;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinSpanningTreeSolution {

    /**
     * 最小生成树算法
     *
     * @param n
     * @param m
     * @param cost
     * @return
     */
    public int miniSpanningTree(int n, int m, int[][] cost) {
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) //初始父亲设置为自己
            parent[i] = i;
        Arrays.sort(cost, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        }); //边权递增排序
        int res = 0;
        for (int i = 0; i < cost.length; i++) { //遍历所有的边，将连通的放入同一个并查集
            int x = cost[i][0];
            int y = cost[i][1];
            int z = cost[i][2];
            int px = find(parent, x); //查找x的最上边父亲
            int py = find(parent, y); // 查找y的最上边父亲
            if (px != py) { //如果二者不在同一个集合
                res += z; //边加入
                parent[px] = py; //设置二者在同一个集合
            }
        }
        return res;
    }

    int find(int[] parent, int x) { //向上找到最高的父亲
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

}
