package com.weijinqian;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumOfIsland {

    /**
     * NC109 岛屿数量
     *
     * @param grid
     * @return
     */
    public int solve(char[][] grid) {
        // write code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 使用bfs来做
        int res = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='0'|| hasVisited[i][j]){
                    continue;
                }
                queue.add(new int[]{i, j});
                while (queue.size() != 0) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];
                    if (grid[x][y] == '0') {
                        continue;
                    }
                    if (x > 0) {
                        if (grid[x - 1][y] == '1' && !hasVisited[x - 1][y]) {
                            queue.add(new int[]{x - 1, y});
                        }
                    }
                    if (x < m - 1) {
                        if (grid[x + 1][y] == '1' && !hasVisited[x + 1][y]) {
                            queue.add(new int[]{x + 1, y});
                        }
                    }
                    if (y > 0) {
                        if (grid[x][y - 1] == '1' && !hasVisited[x][y - 1]) {
                            queue.add(new int[]{x, y - 1});
                        }
                    }
                    if (y < n - 1) {
                        if (grid[x][y + 1] == '1' && !hasVisited[x][y + 1]) {
                            queue.add(new int[]{x, y + 1});
                        }
                    }
                    hasVisited[x][y] = true;
                }
                res += 1;
            }
        }
        return res;
    }
}
