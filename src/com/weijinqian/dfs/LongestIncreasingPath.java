package com.weijinqian.dfs;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingPath {
    /**
     * 329. 矩阵中的最长递增路径
     * 求的是最长路径，不是路径和
     *
     * @param matrix
     * @return
     */
    int maxValue = 0;
    Map<String, Integer> mem = new HashMap<>();

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 避免再次访问
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                DFS(matrix, m, n, i, j, isVisited);
            }
        }
        return maxValue;

    }

    int DFS(int[][] matrix, int m, int n, int i, int j, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }
        String key = i + "_" + j;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        int max = 1;
        // 上
        if (i > 0 && matrix[i][j] < matrix[i - 1][j] && !isVisited[i - 1][j]) {
            isVisited[i - 1][j] = true;
            max = Math.max(DFS(matrix, m, n, i - 1, j, isVisited) + 1, max);
            isVisited[i - 1][j] = false;
        }
        // 下
        if (i < (m - 1) && matrix[i][j] < matrix[i + 1][j] && !isVisited[i + 1][j]) {
            isVisited[i + 1][j] = true;
            max = Math.max(DFS(matrix, m, n, i + 1, j, isVisited) + 1, max);
            isVisited[i + 1][j] = false;
        }
        // 左
        if (j > 0 && matrix[i][j] < matrix[i][j - 1] && !isVisited[i][j - 1]) {
            isVisited[i][j - 1] = true;
            max = Math.max(DFS(matrix, m, n, i, j - 1, isVisited) + 1, max);
            isVisited[i][j - 1] = false;
        }
        // 右
        if (j < (n - 1) && matrix[i][j] < matrix[i][j + 1] && !isVisited[i][j + 1]) {
            isVisited[i][j + 1] = true;
            max = Math.max(DFS(matrix, m, n, i, j + 1, isVisited) + 1, max);
            isVisited[i][j + 1] = false;
        }
        if (max > mem.getOrDefault(key, 0)) {
            maxValue = Math.max(max, maxValue);
            mem.put(key, max);
        }
        return max;

    }

    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    public int longestIncreasingPath1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}
