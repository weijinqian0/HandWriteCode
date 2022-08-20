package com.weijinqian.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindSubstringInWraproundString {

    /**
     * 467. 环绕字符串中唯一的子字符串
     * 好像没有好的办法，写一个全遍历，遍历p的子串是否是环绕子串
     *
     * @param p
     * @return
     */
    String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
    Set<String> memory = new HashSet<>();

    public int findSubstringInWraproundString(String p) {

        if (p == null || p.length() == 0) {
            return 0;
        }

        if (memory.contains(p)) {
            return 0;
        }
        if (p.length() == 1 && s.contains(p)) {
            memory.add(p);
            return 1;
        }

        int len = p.length();
        int res = isIn(p, s) && !memory.contains(p) ? 1 : 0;
        for (int i = 1; i < len; i++) {
            res += findSubstringInWraproundString(p.substring(0, i)) + findSubstringInWraproundString(p.substring(i));
        }
        memory.add(p);
        return res;
    }

    public boolean isIn(String p, String s) {
        if (p.length() < 26) {
            return s.contains(p);
        }
        String pSub = p.replaceAll("abcdefghijklmnopqrstuvwxyz", "");
        return s.contains(pSub);
    }

    /**
     * 将问题转化成了：以i结尾的且在s中的子串长度
     * dp[i] 表示在s中的以i结尾的最长子串
     * @param p
     * @return
     */
    public int findSubstringInWraproundString1(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); ++i) {
            // 后面这个是校验当前是否是在s中的子串
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) { // 字符之差为 1 或 -25
                ++k;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }
}
