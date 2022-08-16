package com.weijinqian.dfs;

import java.util.HashMap;
import java.util.Map;

public class GetMoneyAmount {

    /**
     * 375. 猜数字大小 II
     *
     * @param n
     * @return
     */
    Map<String, Integer> memory = new HashMap<>();

    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        return DFS(1, n);
    }

    public int DFS(int left, int right) {
        String key = left + "_" + right;
        if (left >= right) {
            return 0;
        }
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        int res = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            res = Math.min(Math.max(DFS(left, i - 1), DFS(i + 1, right)) + i, res);
        }
        memory.put(key, res);
        return res;
    }
}
