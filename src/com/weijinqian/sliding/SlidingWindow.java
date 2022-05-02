package com.weijinqian.sliding;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    public void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!need.containsKey(c)) {
                need.put(c, 0);
            } else {
                need.put(c, need.get(c) + 1);
            }
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            right++;
            // 进行窗口的一系列更新
            // ...
            System.out.println("left:" + left + "right:" + right);

            //window need shrink 条件判断
            boolean isNeedShrink = false;
            while (isNeedShrink) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内的数据一系列更新
                // ...
            }
        }
    }
}
