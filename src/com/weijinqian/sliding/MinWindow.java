package com.weijinqian.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 */
public class MinWindow {
    /**
     * 最小子串
     *
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : T.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < S.length()) {
            char c = S.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c) == window.get(c)) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = S.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d)) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : S.substring(start, start + len);
    }
}
