package com.weijinqian.other;

import java.util.Stack;

public class IsPopOrderSolution {
    Stack<Integer> stack = new Stack<>();

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }

        int cur = 0;
        int i = 0;
        for (i = 0; i < popA.length; i++) {
            int idx = findIdxInPushA(popA[i], pushA);
            if (idx == -1) {
                return false;
            }
            if (idx >= cur) {
                while (cur <= idx) {
                    stack.push(pushA[cur]);
                    cur++;
                }
                stack.pop();
            } else {
                while (!stack.empty() && stack.peek() != popA[i]) {
                    stack.pop();
                }
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (cur == popA.length && stack.empty()) {
            return true;
        }
        return false;
    }

    private int findIdxInPushA(int number, int[] pushA) {
        for (int i = 0; i < pushA.length; i++) {
            if (pushA[i] == number) {
                return i;
            }
        }
        return -1;

    }

}
