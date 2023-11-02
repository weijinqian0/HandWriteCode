package com.weijinqian.dfs;

import java.util.*;

public class GenerateParenthesis {
    /**
     * 22. 括号生成
     * 生成合适的括号，这里存在子问题的嵌套
     * 还是得写dfs算法
     * 题目描述：数字n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     *
     * @param n
     * @return
     */
    Map<Integer, List<String>> memory = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("()"));
        }
        if (memory.containsKey(n)) {
            return memory.get(n);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (String left : generateParenthesis(i)) {
                for (String right : generateParenthesis(n - i - 1)) {
                    res.add("(" + left + ")" + right);
                }
            }
        }
        memory.put(n, res);
        return res;
    }


}
