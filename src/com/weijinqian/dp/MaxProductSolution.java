package com.weijinqian.dp;

// NC83 连续子数组的最大乘积
public class MaxProductSolution {
    /**
     * 由于正负号的关系，所以保存两个值，一个是最大的，一个是小的
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
}
