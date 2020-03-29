package com.weijinqian;

import java.util.*;

public class FirstNotRepeatingCharSolution {

    List<Character> array = new ArrayList<>();
    int[] nums = new int[52];
    Map<Character, Integer> map = new HashMap<>();

    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (!map.keySet().contains(c)) {
                array.add(c);
                map.put(c, i);
            }
            if (Character.isLowerCase(c)) {
                nums[c - 'a']++;
            } else {
                nums[c - 'A' + 26]++;
            }
        }

        for (char tmp : array) {
            if (Character.isLowerCase(tmp)) {
                if (nums[tmp - 'a'] == 1) {
                    return map.get(tmp);
                }
            } else {
                if (nums[tmp - 'A' + 26] == 1) {
                    return map.get(tmp);
                }
            }
        }
        return -1;
    }
}
