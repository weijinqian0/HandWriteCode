package com.weijinqian.other;

import java.util.Stack;

/**
 * 包含最小函数的栈
 * 思路是包含两个栈一个维护正常功能，一个维护当前最小值的栈
 */
public class MinStackSolution {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    int minValue = Integer.MAX_VALUE;

    public void push(int node) {
        data.push(node);
        if (node < minValue) {
            minValue = node;
        }
        min.push(minValue);
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
