package com.weijinqian.dp;

public class Trap {
    /**
     * 42. 接雨水
     * 建模每一个位置，高于当前位置的左右两侧的最大值，然后取得其中的最小值
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        // 当前位置高于它的左侧最大值
        int[] dp1 = new int[len];
        // 当前位置高于它的右侧最大值
        int[] dp2 = new int[len];
        dp1[0] = height[0];
        for (int i = 1; i < len; i++) {
            dp1[i] = Math.max(dp1[i - 1], height[i]);
        }

        dp2[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(dp1[i], dp2[i]) - height[i];
        }
        return res;

    }
}
