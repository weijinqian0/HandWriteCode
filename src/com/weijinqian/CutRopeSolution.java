package com.weijinqian;

public class CutRopeSolution {
    private int[] state;

    public int cutRope(int target) {
        state = new int[target];
        if (target == 2 || target == 3) {
            return target - 1;
        }
        return DFS(target);
    }

    /**
     * 思路1：使用深度优先遍历，同时保存相关的状态
     * 分析：
     * f(0,8)
     * /    |     |       |       |       |       |
     * f(1,7) f(2,6) f(3,5)  f(4,4)  f(5,3) f(6,2)  f(7,1)
     * f(1,1,6) f(1,2,5) f(1,3,4)
     * <p>
     * 可见 这里有大量的子问题  如果能将子问题的答案保存好，就可以降低很多的不必要的计算
     *
     * @return
     */
    private int DFS(int target) {
        if (target <= 0) {
            return 1;
        }
        if (state[target - 1] != 0) {
            return state[target - 1];
        }
        int max = 0;
        for (int i = 1; i <= target; i++) {
            int tmp = DFS(target - i) * i;
            if (tmp > max) {
                max = tmp;
            }
        }
        state[target - 1] = max;
        return max;
    }

    /**
     * 这种题目很难使用状态矩阵来做  因为每次选择可以重复，导致无法处理，所以这里选择公式的推导算法
     * <p>
     * <p>
     * 使用DP算法
     * 1. 使用标志当前是否选择切分的方式
     * 定义一个二维矩阵 state[target][target]
     * 行代表当前的长度，列表示当前剩余长度，元素表示当前的乘积
     * <p>
     * 2. 每次遍历 需要根据上一行的值，填满相关位置
     *
     * @param target
     */
    public void DP(int target) {
        int[][] state = new int[target][target + 1];

        // 选择和没选择 当前的乘积都是1
        state[0][0] = 1;
        state[0][target] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j <= target; j++) {
                if (state[i - 1][j] != 0) {
                    // 选择
                    state[i][j - i] = state[i - 1][j] * i;
                    // 不选择
                    state[i][j] = state[i - 1][j];
                }
            }

        }
    }

    /**
     * 使用公式法来计算：
     * f(9)=max(1*f(9-1),2*f(9-2),...)
     * 所以 f(9)其实是依赖之前的8个值，然后求个最大值
     *
     * @param target
     */
    public int DP1(int target) {
        int[] states = new int[target];
        states[0] = 1;
        states[1] = 2;
        states[2] = 3;
        for (int i = 3; i < target; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int tmp = (j + 1) * states[i - j - 1];
                if (tmp > max) {
                    max = tmp;
                }
            }
            states[i] = max;
        }
        return states[target - 1];
    }

}
