package com.weijinqian;

public class HasPathSolution extends Solution {
    boolean isFind = false;
    char[] matrix1;
    int mRows;
    int mCols;
    boolean[] isVisited;
    char[] str1;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        matrix1 = matrix;
        mRows = rows;
        mCols = cols;
        str1 = str;
        isVisited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                DFS(i, j, 0);
            }
        }
        return isFind;
    }

    /**
     * 使用深度优先遍历来做
     */
    private void DFS(int idx, int idy, int curIdx) {
        if (isFind) {
            return;
        }
        if (idx < 0 || idx >= mRows) {
            return;
        }
        if (idy < 0 || idy >= mCols) {
            return;
        }
        if (isVisited[idx * mCols + idy]) {
            return;
        }
        if (matrix1[idx * mCols + idy] != str1[curIdx]) {
            return;
        }
        if ((str1.length - 1) == curIdx) {
            isFind = true;
            return;
        }
        isVisited[idx * mCols + idy] = true;
        DFS(idx - 1, idy, curIdx + 1);
        DFS(idx + 1, idy, curIdx + 1);
        DFS(idx, idy - 1, curIdx + 1);
        DFS(idx, idy + 1, curIdx + 1);
        isVisited[idx * mCols + idy] = false;

    }

}
