package com.weijinqian.sliding;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaxInWindowSolution {

    /**
     * 总体思路：
     * 如果当前数字大于队列尾最后一个，则将之前小于它的都抛弃掉
     * 如果小于则直接添加进来，
     * 本质上是维护一个窗口当前最大值的列表，是否在窗口内则用下标判断
     * 是一个单调递减的序列
     * <p>
     * 怎么保障存储的数值在当前窗口中呢？
     * 通过存储下标  动态判断。
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0) {
            return res;
        }
        if (size > num.length) {
            return res;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {
            if (queue.isEmpty() || num[queue.getLast()] >= num[i]) {
                queue.addLast(i);
            } else {
                while (!queue.isEmpty() && num[queue.getLast()] < num[i]) {
                    queue.removeLast();
                }
                queue.addLast(i);
            }
            if ((i - queue.getFirst() + 1) > size) {
                queue.removeFirst();
            }
            if (i >= (size - 1)) {
                res.add(num[queue.getFirst()]);
            }
        }
        return res;
    }
}
