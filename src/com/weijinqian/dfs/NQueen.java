package com.weijinqian.dfs;

import java.util.LinkedList;

public class NQueen {
    private LinkedList<String> res = new LinkedList<>();

    public LinkedList<String> getNQueen(int n) {
        LinkedList<StringBuilder> board = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < n; j++) {
                cur.append(".");
            }
        }

        dfs(board, 0);
        return res;
    }

    /**
     * 这是是寻找所有的情况
     *
     * @param board
     * @param row
     */
    public void dfs(LinkedList<StringBuilder> board, int row) {
        if (row == board.size()) {
            res.add(board.toString());
            return;
        }
        int n = board.get(row).length();
        for (int i = 0; i < n; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board.get(row).setCharAt(i, 'Q');
            dfs(board, row + 1);
            board.get(row).setCharAt(i, '.');
        }
    }

    /**
     * 只要查找出来一次即可，这样就在返回true就直接返回
     *
     * @param board
     * @param row
     * @return
     */
    public boolean dfs1(LinkedList<StringBuilder> board, int row) {
        if (row == board.size()) {
            res.add(board.toString());
            return true;
        }
        int n = board.get(row).length();
        for (int i = 0; i < n; i++) {
            if (!isValid(board, row, i)) {
                continue;
            }
            board.get(row).setCharAt(i, 'Q');
            if (dfs1(board, row + 1)) {
                return true;
            }
            board.get(row).setCharAt(i, '.');
        }
        return false;
    }

    private boolean isValid(LinkedList<StringBuilder> board, int row, int col) {
        int n = board.size();
        // 检查列中是否有皇后冲突
        for (int i = 0; i < row; i++) {
            if (board.get(row).charAt(col) == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
