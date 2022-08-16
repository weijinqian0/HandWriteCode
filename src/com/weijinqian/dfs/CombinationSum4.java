package com.weijinqian.dfs;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum4 {

    /**
     * 377. 组合总和 Ⅳ
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
