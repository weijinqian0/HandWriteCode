package com.weijinqian.other;

import java.util.*;

// n 数之和问题
public class NSum {

    /**
     * // NC61 两数之和
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        if (numbers == null || numbers.length <= 1) {
            return new int[]{};
        }
        Map<Integer, Integer> reverseMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            reverseMap.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (reverseMap.containsKey(target - numbers[i]) && i != reverseMap.get(target - numbers[i])) {
                return new int[]{i + 1, reverseMap.get(target - numbers[i]) + 1};
            }
        }
        return new int[]{};
    }

    /**
     * 两数之和，使用排序，二分查找的方式
     *
     * @param numbers
     * @param target
     * @return 返回的是所有等于target的去重之后的组合, 时间复杂度为O(nlogn)
     */
    public ArrayList<ArrayList<Integer>> twoSumTarget(int[] numbers, int start, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        Arrays.sort(numbers);
        int left = start;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                int tmpLeft = numbers[left];
                int tmpRight = numbers[right];
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(tmpLeft);
                tmp.add(tmpRight);
                res.add(tmp);
                while (left < right && tmpLeft == numbers[left]) {
                    left++;
                }
                while (left < right && tmpRight == numbers[right]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return res;
    }

    /**
     * 返回两数之和为0的数组
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> twoSum(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(num);
        return twoSumTarget(num, 0, 0);
    }


    /**
     * NC54 三数之和为0
     * 三数之和，就是两数之和
     *
     * @param num
     * @return
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> triples = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> res = twoSumTarget(num, i + 1, 0 - num[i]);
            for (ArrayList<Integer> tmp : res) {
                tmp.add(num[i]);
                Collections.sort(tmp);
                triples.add(tmp);
            }
            while ((i < num.length - 1) && num[i] == num[i + 1]) {
                i++;
            }
        }
        return triples;
    }
}
