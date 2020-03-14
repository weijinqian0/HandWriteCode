package com.weijinqian;

import java.util.ArrayList;
import java.util.List;

public class RobotSolution {
    List<List<Integer>> area;
    int mRows;
    int mCols;
    int mThreshold;

    public int movingCount(int threshold, int rows, int cols) {
        mThreshold = threshold;
        initArea(rows, cols);
        return DFS(0, 0);
    }

    // 使用状态矩阵来做  先定义矩阵  表示true  false  用来标志 是否采用该方案
    public int DP(int mThreshold, int mRows, int mCols) {
        boolean[][] states = new boolean[mRows * mCols][mRows * mCols];
        int curRow = 0;
        int curCol = 0;
        states[0][0] = true;
        for (int i = 1; i < mCols * mRows; i++) {
            for (int k = 0; k < mRows * mCols; k++) {
                curRow = k / mCols;
                curCol = k % mCols;
                if (states[i - 1][k]) {
                    states[i][k] = true;
                    if (check(curRow - 1, curCol, mRows, mCols, mThreshold)) {
                        states[i][(curRow - 1) * mCols + curCol] = true;
                    }
                    if (check(curRow + 1, curCol, mRows, mCols, mThreshold)) {
                        states[i][(curRow + 1) * mCols + curCol] = true;
                    }
                    if (check(curRow, curCol - 1, mRows, mCols, mThreshold)) {
                        states[i][curRow * mCols + curCol - 1] = true;
                    }
                    if (check(curRow, curCol + 1, mRows, mCols, mThreshold)) {
                        states[i][curRow * mCols + curCol + 1] = true;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < mCols * mRows; i++) {
            if (states[mRows * mCols - 1][i]) {
                sum++;
            }
        }

        return sum;

    }

    /**
     * 精简申请的空间大小
     *
     * @param mThreshold
     * @param mRows
     * @param mCols
     * @return
     */
    public int DP1(int mThreshold, int mRows, int mCols) {
        boolean[] states = new boolean[mRows * mCols];
        int curRow = 0;
        int curCol = 0;
        states[0] = true;
        for (int i = 1; i < mCols * mRows; i++) {
            for (int k = 0; k < mRows * mCols; k++) {
                curRow = k / mCols;
                curCol = k % mCols;
                if (states[k]) {
                    if (check(curRow - 1, curCol, mRows, mCols, mThreshold)) {
                        states[(curRow - 1) * mCols + curCol] = true;
                    }
                    if (check(curRow + 1, curCol, mRows, mCols, mThreshold)) {
                        states[(curRow + 1) * mCols + curCol] = true;
                    }
                    if (check(curRow, curCol - 1, mRows, mCols, mThreshold)) {
                        states[curRow * mCols + curCol - 1] = true;
                    }
                    if (check(curRow, curCol + 1, mRows, mCols, mThreshold)) {
                        states[curRow * mCols + curCol + 1] = true;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < mCols * mRows; i++) {
            if (states[i]) {
                sum++;
            }
        }

        return sum;

    }

    boolean check(int row, int col, int mRows, int mCols, int mThreshold) {
        if (row < 0 || row >= mRows) {
            return false;
        }
        if (col < 0 || col >= mCols) {
            return false;
        }
        if ((getNumberSum(row) + getNumberSum(col)) > mThreshold) {
            return false;
        }
        return true;
    }


    public int DFS(int row, int col) {
        if (row < 0 || row >= mRows) {
            return 0;
        }
        if (col < 0 || col >= mCols) {
            return 0;
        }
        if (area.get(row).get(col) != 0) {
            return 0;
        }

        if ((getNumberSum(row) + getNumberSum(col)) > mThreshold) {
            return 0;
        }
        area.get(row).set(col, 1);
        int left = DFS(row, col - 1);
        int top = DFS(row - 1, col);
        int right = DFS(row, col + 1);
        int bottom = DFS(row + 1, col);
        int max1 = left + top + right + bottom + 1;
        return max1;
    }

    /**
     * 数字各位之和
     *
     * @param number
     * @return
     */
    private int getNumberSum(int number) {
        int sum = 0;
        while (number % 10 != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private void initArea(int rows, int cols) {
        mRows = rows;
        mCols = cols;
        area = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                list.add(0);
            }
            area.add(list);
        }
    }
}
