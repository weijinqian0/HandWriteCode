package com.weijinqian.dp;

/**
 * NC108 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 三个正方形才能够长一个大正方形，所以考虑左上，上，左，三个最大的变成
 * 这个题目可能算简单的了
 */
public class MaxSquareSolution {

    public int solve(char[][] matrix) {
        // write code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
            }
        }

        int maxEdge = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                    if (dp[i][j] > maxEdge) {
                        maxEdge = dp[i][j];
                    }
                }
            }
        }
        return (int) Math.pow(maxEdge, 2);

    }
}
