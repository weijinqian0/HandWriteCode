package com.weijinqian.dp;

public class FindGreatestSumOfSubArraySolution {

    /**
     * 使用我们正常的思路
     * <p>
     * 使用状态表的方式来处理
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 子数组 是数组中的一个连续部分。
     *
     * 二、示例
     *
     * 2.1> 示例 1：
     *
     * 【输入】nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 【输出】6
     * 【解释】连续子数组 [4,-1,2,1] 的和最大，为 6
     * 2.2> 示例 2：
     *
     * 【输入】nums = [1]
     * 【输出】1
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

    public int maxSubArray(int[] nums) {
        int result = nums[0], pre = 0;
        for (int num: nums) {
            pre = Math.max(num, pre + num);
            result = Math.max(result, pre);
        }
        return result;
    }

}
