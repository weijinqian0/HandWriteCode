package com.weijinqian.dp;

import java.util.HashMap;

public class CutRopeSolution {

    /**
     * 割绳子
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        // 因为必须割 所以需要特殊情况考虑
        if (target == 2 || target == 3) {
            return target - 1;
        }
        return DFS(target);
    }

    /**
     * 割绳子
     * 切多少段都是可以的，只要最后的乘积最大，感觉用递归的方式最好做
     *
     * @param target
     * @return
     */
    HashMap<Integer, Integer> mem = new HashMap<>();

    public int DFS(int target) {
        if (target <= 1) {
            return 0;
        }
        if (mem.containsKey(target)) {
            return mem.get(target);
        }
        int max = target;
        for (int i = 1; i < target; i++) {
            // 不切和切一部分对比
            max = Math.max(max, i * DFS(target - i));
        }
        mem.put(target, max);
        return max;
    }

    /**
     * 既然可以写一个DFS，就能写一个dp的方法
     * dp 就是用于记录当前绳子长度的最大值
     *
     * 之前写的太复杂了，直接用新的代码
     *
     * @param target
     * @return
     */
    public int cutRopeDp(int target) {
        if (target <= 1) {
            return 0;
        }
        if (target == 2 || target == 3) {
            return target - 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                // 不割，或者是从之前的开始割
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[target];
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

    /**
     * 343. 整数拆分
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // 拆或者不拆
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }

}
