package com.weijinqian.union;

import java.util.*;

// 952. 按公因数计算最大组件大小
public class LargestComponentSize {
    /**
     * 获取所有因子，采用倒排拉链的方式
     * 那么问题就变成了怎么获取所有的因子的问题
     *
     * @param nums
     * @return
     */

    private static int max_factor = 0;

    public int largestComponentSize(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 这样就相当于构图了，然后就是查找图的最大团
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int v : get_all_factors(nums[i])) {
                if (!map.containsKey(v)) {
                    map.put(v, new HashSet<>());
                }
                map.get(v).add(nums[i]);
            }
        }
        // 只要联通就算，每一个数字，都维护一个set，用于表示可以联通的序列，然后记录最大值就是了
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        // 初始化map
        for (int i = 0; i < nums.length; i++) {
            graph.put(nums[i], new HashSet<>());
        }
        for (int key : map.keySet()) {
            for (int v : map.get(key)) {
                graph.get(v).addAll(map.get(key));
            }
        }
        for (int i: nums) {
            dfs(nums[0], graph);
        }
        return max_factor;
    }

    /**
     * 由于每次更新，都需要更新之前所有的节点的信息，所以需要使用dfs来处理
     * 当前的节点，所能联通的所有节点
     *
     * @param key
     * @param graph
     */
    public void dfs(int key, Map<Integer, Set<Integer>> graph) {
        if (graph == null) {
            return;
        }
        for (int v : graph.get(key)) {
            if (key == v) {
                continue;
            }
            graph.get(key).addAll(graph.get(v));
            max_factor = Math.max(max_factor, graph.get(key).size());
            dfs(v, graph);
        }
    }

    public List<Integer> get_all_factors(int num) {
        if (num == 1) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
