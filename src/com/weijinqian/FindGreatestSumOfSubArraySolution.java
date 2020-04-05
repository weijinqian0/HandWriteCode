package com.weijinqian;

public class FindGreatestSumOfSubArraySolution {

    /**
     * 使用我们正常的思路
     * <p>
     * 使用状态表的方式来处理
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int len = array.length;
        int[] states = new int[len];

        states[0] = array[0];
        for (int i = 1; i < len; i++) {
            // 这里不是选择和不选择  而是判断与之前联合与不联合
            states[i] = Math.max(states[i - 1] + array[i], array[i]);
        }

        int max = states[0];
        for (int i = 0; i < len; i++) {
            if (states[i] > max) {
                max = states[i];
            }
        }
        return max;
    }

}
