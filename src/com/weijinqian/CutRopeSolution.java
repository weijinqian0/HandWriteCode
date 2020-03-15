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
     * f(1,6) f(2,5) f(3,4)
     * 所以重复子结构其实是f(1) f(2)等类似特征
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
     * 使用DP状态表的方式做算法
     * 1. 使用标志当前是否选择切分的方式
     * 定义一个二维矩阵 state[target][target]
     * 行代表当前的长度，列表示当前长度，元素表示当前的乘积
     * <p>
     * 2. 每次遍历 需要根据上一行的值，填满相关位置
     *
     * 状态表相当于对DP做选择上的迭代（BFS）
     * 状态方程是对DP做目标上的迭代（DFS）
     *
     * @param target
     */
    public int DP(int target) {
        if (target <= 3) {
            return target - 1;
        }
        // 0表示选择切分为1，只能切分
        int[][] state = new int[target][target];

        // 这里变成了1-target种选择了
        for (int i = 0; i < target; i++) {
            state[0][i] = i + 1;
        }

        for (int i = 1; i < target; i++) {
            for (int j = 0; j < target; j++) {
                if ((state[i - 1][j] + (j + 1)) <= target) {
                    state[i][j] = state[i - 1][j] * (j + 1);
                } else {
                    state[i][j] = state[i - 1][j];
                }
            }

        }

        int max = 0;
        for (int i = 0; i < target; i++) {
            if (state[target - 1][i] > max) {
                max = state[target - 1][i];
            }
        }
        return max;
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
