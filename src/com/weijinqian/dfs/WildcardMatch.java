package com.weijinqian.dfs;

import java.util.HashMap;

/**
 * 44. 通配符匹配
 */
public class WildcardMatch {
    /**
     * 通配符匹配问题
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p == null) {
            return s == null;
        }
        if (p.length() == 0) {
            return s.equals("");
        }

        return isMatch(s, p, 0, 0);
    }

    HashMap<String, Boolean> memory = new HashMap<>();

    public boolean isMatch(String s, String p, int s1, int p1) {
        String key = "" + s1 + p1;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        boolean res = false;
        // 最后再写停止条件
        if (s1 == s.length()) {
            res = p1 == p.length() || p1 < p.length() && p.charAt(p1) == '*' && isMatch(s, p, s1, p1 + 1);
        } else if (p1 == p.length()) {
            res = p1 > 1 && p.charAt(p1 - 1) == '*';
        } else if (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '?') {
            res = isMatch(s, p, s1 + 1, p1 + 1);
        } else if (p.charAt(p1) == '*') {
            res = isMatch(s, p, s1, p1 + 1) || isMatch(s, p, s1 + 1, p1);
        }
        memory.put(key, res);
        return res;
    }
}
