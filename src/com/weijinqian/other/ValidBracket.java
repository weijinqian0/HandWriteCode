package com.weijinqian.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBracket {

    /**
     * 是否是有效括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                stack.add(cur);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (cur == map.get(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

}
