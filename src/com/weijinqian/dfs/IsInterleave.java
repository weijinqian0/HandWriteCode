package com.weijinqian.dfs;

import java.util.HashMap;
import java.util.Map;

public class IsInterleave {
    /**
     * 97. 交错字符串
     * 和之前的一样，既然有规律，就按照规律拆解子问题
     * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
     *
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
     *
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
     * 注意：a + b 意味着字符串 a 和 b 连接。
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.equals("") && s2.equals("") && s3.equals("")) {
            return true;
        }
        return isPreContains(s1, s2, s3) || isPreContains(s2, s1, s3);
    }

    Map<String, Boolean> memory = new HashMap<>();

    /**
     * 表示s1和s3是否存在交叉
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isPreContains(String s1, String s2, String s3) {
        String key = s1 + "_" + s3;
        if (s1.equals(s3)) {
            return s2.equals("");
        }
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        if (s1.length() > s3.length()) {
            memory.put(key, false);
            return false;
        }

        int len = s1.length();
        int idx = -1;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s3.charAt(i)) {
                idx = i;
            } else {
                break;
            }
        }
        boolean res = false;
        if (idx != -1) {
            for (int i = 0; i <= idx; i++) {
                res = res || isPreContains(s2, s1.substring(i + 1, s1.length()), s3.substring(i + 1, s3.length()));
            }
        }
        memory.put(key, res);
        return res;
    }
}
