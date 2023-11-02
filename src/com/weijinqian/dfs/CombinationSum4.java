package com.weijinqian.dfs;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum4 {

    /**
     * 377. 组合总和 Ⅳ
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     *
     * 示例:
     *
     * nums = [1, 2, 3] target = 4
     *
     * 所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
     *
     * 请注意，顺序不同的序列被视作不同的组合。
     *
     * 因此输出为 7。
     *
     * @param nums
     * @param target
     * @return
     */
    Map<Integer, Integer> memory = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return DFS(nums, target, 0);
    }

    int DFS(int[] nums, int target, int curValue) {
        if (curValue == target) {
            return 1;
        }
        if (curValue > target) {
            return 0;
        }
        if (memory.containsKey(curValue)) {
            return memory.get(curValue);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curValue + nums[i] <= target) {
                res += DFS(nums, target, curValue + nums[i]);
            }
        }
        memory.put(curValue, res);
        return res;
    }
}
