package com.weijinqian;

import java.util.ArrayList;

public class PrintMatrixSolution {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length;
        int column = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = column - 1;
        int bottom = rows - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            up++;
            if (up > bottom) {
                break;
            }
            for (int i = up; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (left > right) {
                break;
            }

            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;

            if (up > bottom) {
                break;
            }

            for (int i = bottom; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }

        return res;
    }
}
