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
     * //性质1：
     *         //  以字母结尾的唯一子字符串的最大数目等于以该字母结尾的最大连续子字符串的长度。例如“abcd”，
     *         // 以“d”结尾的唯一子字符串的最大数目是4，显然它们是“abcd”、“bcd”、“cd”和“d”。
     *         //性质2：
     *         //如果有重叠，我们只需要考虑最长的一个，因为它覆盖了所有可能的子字符串。示例：“abcdbcd”，
     *         // 以“d”结尾的唯一子字符串的最大数目为4，并且由第二个“bcd”部分形成的所有子字符串都已包含在4个子字符串
     * ————————————————
     * 版权声明：本文为CSDN博主「阿飞算法」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/wat1r/article/details/124959392
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
