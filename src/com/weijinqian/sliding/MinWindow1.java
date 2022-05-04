package com.weijinqian.sliding;

import java.util.HashMap;
import java.util.Map;

public class MinWindow1 {
    /**
     * NC28 最小覆盖子串
     *
     * @return
     */
    public String minWindow(String S, String T) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            need.put(T.charAt(i), need.getOrDefault(T.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        // 记录满足条件的左右下标
        int minLeft = 0;
        int minRight = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < S.length()) {
            char cr = S.charAt(right);
            right++;
            // 更新窗口内的变量，只有当前key符合need才有意义
            if (need.containsKey(cr)) {
                window.put(cr, window.getOrDefault(cr, 0) + 1);
                if (window.get(cr) == need.get(cr)) {
                    valid++;
                }
            }
            // 当满足要求之后就缩减左边界
            while (valid == need.size()) {
                // 满足要求了，就要记录下来
                if (right - left < minLen) {
                    minLeft = left;
                    minRight = right;
                    minLen = right - left;
                }
                char cl = S.charAt(left);
                left++;
                if (need.containsKey(cl)) {
                    window.put(cl, window.getOrDefault(cl, 0) - 1);
                    if (window.get(cl) < need.get(cl)) {
                        valid--;
                    }
                }
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : S.substring(minLeft, minRight);
    }
}
