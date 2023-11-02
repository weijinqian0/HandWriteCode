package com.weijinqian.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分割回文串
 */
public class Partition {


    /**
     * 131. 分割回文串
     * 分割之后的每个子串都是回文串
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * 回文串 是正着读和反着读都一样的字符串。
     *
     * 示例 1：
     *
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     *
     * 输入：s = "a"
     * 输出：[["a"]]
     *
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        DFS(s, res, new ArrayList<>());
        return res;
    }


    /**
     * 将一个s拆分成为回文子串
     *
     * @param s
     * @return
     */
    public void DFS(String s, List<List<String>> res, List<String> once) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(once));
            return;
        }
        if (s.length() == 1) {
            List<String> tmp = new ArrayList<>(once);
            tmp.add(s);
            res.add(tmp);
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (!ishuiwen(sub)) {
                continue;
            }
            once.add(sub);
            DFS(s.substring(i), res, once);
            once.remove(once.size() - 1);
        }

    }

    public boolean ishuiwen(String s) {
        if (s.length() == 1) {
            return true;
        }
        int len = s.length();
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    Map<String, Integer> memory = new HashMap<>();

    /**
     * 132. 分割回文串 II
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
     * <p>
     * 返回符合要求的 最少分割次数 。
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (memory.containsKey(s)) {
            return memory.get(s);
        }
        if (ishuiwen(s)) {
            memory.put(s, 0);
            return 0;
        }
        int minRes = s.length() - 1;
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(0, i);
            if (ishuiwen(sub)) {
                minRes = Math.min(minCut(s.substring(i)) + 1, minRes);
            }
        }
        memory.put(s, minRes);
        return minRes;
    }

}
