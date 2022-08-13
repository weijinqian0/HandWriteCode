package com.weijinqian.dp;

// NC83 连续子数组的最大乘积
public class MaxProductSolution {
    /**
     * 由于正负号的关系，所以保存两个值，一个是最大的，一个是小的
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        // 这里面其实就是根据乘积的特性，所以维护了两个dp数组
        int curMaxVal = nums[0];
        int curMinVal = nums[0];
        int maxVal = nums[0];
        for (int i = 1; i < len; i++) {
            int tmpMax = curMaxVal;
            int tmpMin = curMinVal;
            curMaxVal = Math.max(nums[i], Math.max(tmpMax * nums[i], tmpMin * nums[i]));
            curMinVal = Math.min(nums[i], Math.min(tmpMax * nums[i], tmpMin * nums[i]));
            maxVal = Math.max(maxVal, curMaxVal);
        }
        return maxVal;
    }

    /**
     * 152. 乘积最大子数组
     * leetcode 连续最大子数组，再写一遍
     *
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dpMin = new int[nums.length + 1];
        int[] dpMax = new int[nums.length + 1];
        dpMin[0] = 1;
        dpMax[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i - 1], Math.max(nums[i - 1], dpMin[i - 1] * nums[i - 1]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i - 1], Math.min(nums[i - 1], dpMax[i - 1] * nums[i - 1]));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
