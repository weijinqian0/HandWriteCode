package com.weijinqian.dfs;

import java.util.HashMap;
import java.util.Map;

public class GetMoneyAmount {

    /**
     * 375. 猜数字大小 II
     * 我们正在玩一个猜数游戏，游戏规则如下：
     *
     * 我从 1 到 n 之间选择一个数字。
     * 你来猜我选了哪个数字。
     * 如果你猜到正确的数字，就会 赢得游戏 。
     * 如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
     * 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
     * 给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
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
