package com.weijinqian.sliding;

import java.util.HashMap;
import java.util.Map;

public class LenLongestSub {
    /**
     * 最长无重复子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubString(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(c, window.getOrDefault(c, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;

    }
}
