package com.weijinqian.dp;

public class MaxRectangle {

    /**
     * 85. 最大矩形，没写出来，先放一放
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        return maxRec(matrix, 0, 0, m - 1, n - 1);


    }

    public int maxRec(char[][] matrix, int bi, int bj, int ei, int ej) {
        // 首节点即尾节点
        if (bi == ei && bj == ej) {
            return matrix[bi][bj];
        }
        for (int i = bi; i <= ei; i++) {
            for (int j = bj; j <= ej; j++) {
                if (matrix[i][j] == '0') {
                    return 0;
                }
                int leftTop = maxRec(matrix, bi, bj, i, j);
                int rightTop = maxRec(matrix, bi, j, i, ej);
                int leftBottom = maxRec(matrix, i, bj, ei, j);
                int rightBottom = maxRec(matrix, i, j, ei, ej);
                if (leftTop == 0 || rightTop == 0 || leftBottom == 0 || rightBottom == 0) {
                    return Math.max(leftTop, Math.max(rightTop, Math.max(leftBottom, rightBottom)));
                } else {
                    return leftTop + rightTop + leftBottom + rightBottom;
                }

            }
        }
        return 0;
    }
}
