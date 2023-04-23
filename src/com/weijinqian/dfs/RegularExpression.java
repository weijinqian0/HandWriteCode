package com.weijinqian.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 10. 正则表达式匹配
 */
public class RegularExpression {

    /**
     * 是否match
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 直接用递归的方式做
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        return isMatch1(s, p, 0, 0);
    }

    /**
     * 自己写的复杂了
     * 重新写，总共有几种情况呢
     * 主要是考虑下一位为*的情况
     * 当前位有*号，如果前一位相等，则分为s+1 p，s+1 p+1, s,p+1
     * 如果上一位不等，那么要想进行下去，则分为 s+1, p+1
     *
     * @param s
     * @param p
     * @param s1
     * @param p1
     * @return
     */
    private Map<String, Boolean> memory = new HashMap<>();

    public boolean isMatch(String s, String p, int s1, int p1) {
        String key = "" + s1 + p1;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        if (s1 == s.length()) {
            return p1 == p.length() || (p1 + 1) < p.length() && p.charAt(p1 + 1) == '*' && isMatch(s, p, s1, p1 + 2);
        }
        if (p1 == p.length()) {
            return false;
        }
        boolean res = false;
        // 当前相等，下一位为*，或者不为*
        if (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '.') {
            if (p1 < (p.length() - 1) && p.charAt(p1 + 1) == '*') {
                res = isMatch(s, p, s1 + 1, p1 + 1) || isMatch(s, p, s1 + 1, p1 + 2) || isMatch(s, p, s1, p1 + 2);
            } else {
                res = isMatch(s, p, s1 + 1, p1 + 1);
            }
        } else {
            if (p.charAt(p1) == '*') {
                if (p1 == 0) {
                    res = isMatch(s, p, s1, p1 + 1);
                }
                if (s.charAt(s1) == p.charAt(p1 - 1) || p.charAt(p1 - 1) == '.') {
                    // 匹配n次，1次，0次
                    res = isMatch(s, p, s1 + 1, p1) || isMatch(s, p, s1 + 1, p1 + 1) || isMatch(s, p, s1 - 1, p1 + 1);
                }
            } else if (s.charAt(s1) != p.charAt(p1)) {
                res = p1 < (p.length() - 1) && p.charAt(p1 + 1) == '*' && (isMatch(s, p, s1, p1 + 2));
            }
        }
        memory.put(key, res);
        return res;

    }

    /**
     * labuladong 的题解，省略了中间为*的情况，确实更加简单
     *
     * @param s
     * @param p
     * @param s1
     * @param p1
     * @return
     */
    public boolean isMatch1(String s, String p, int s1, int p1) {
        String key = "" + s1 + p1;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        if (s1 == s.length()) {
            return p1 == p.length() || (p1 + 1) < p.length() && p.charAt(p1 + 1) == '*' && isMatch(s, p, s1, p1 + 2);
        }
        if (p1 == p.length()) {
            return false;
        }
        boolean res = false;
        if (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '.') {
            if (p1 < (p.length() - 1) && p.charAt(p1 + 1) == '*') {
                res = isMatch1(s, p, s1 + 1, p1) || isMatch1(s, p, s1, p1 + 2);
            } else {
                res = isMatch1(s, p, s1 + 1, p1 + 1);
            }
        } else {
            if (p1 < (p.length() - 1) && p.charAt(p1 + 1) == '.') {
                res = isMatch1(s, p, s1 + 1, p1 + 2);
            } else {
                res = false;
            }
        }
        memory.put(key, res);
        return res;
    }

}
