package com.weijinqian.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 87. 扰乱字符串
 */
public class IsScramble {
    /**
     * 87. 扰乱字符串
     * 拆解子问题，依据是：如果s1和s2能拆成两部分，两两能对的上，那么就是拆成了子问题。
     *
     * @param s1
     * @param s2
     * @return
     */
    Map<String, Boolean> memory = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String key = s1 + s2;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        if (!isContains(s1, s2)) {
            memory.put(key, false);
            return false;
        }
        if (s1.equals(s2)) {
            memory.put(key, true);
            return true;
        }
        if (s1.length() == 1) {
            memory.put(key, false);
            return false;
        }
        int len = s1.length();
        boolean a = false;
        boolean b = false;
        for (int i = 1; i < len; i++) {
            if (isContains(s1.substring(0, i), s2.substring(0, i))) {
                a = isScramble(s1.substring(0, i), s2.substring(0, i))
                        && isScramble(s1.substring(i, len), s2.substring(i, len));
            }
            if (isContains(s1.substring(0, i), s2.substring(len - i, len))) {
                b = isScramble(s1.substring(0, i), s2.substring(len - i, len))
                        && isScramble(s1.substring(i, len), s2.substring(0, len - i));
            }
            if (a || b) {
                memory.put(key, true);
                return true;
            }

        }
        memory.put(key, false);
        return false;

    }

    /**
     * s1 和 s2 是包含关系
     *
     * @param s1
     * @param s2
     * @return
     */
    private boolean isContains(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
