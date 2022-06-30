package com.weijinqian.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// NC119 最小的K个数
public class TopkSolution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>(k);
        //根据题意要求，如果K>数组的长度，返回一个空的数组
        if (k > input.length || k == 0)
            return res;
        //创建最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        //先在堆中放数组的前k个元素
        for (int i = 0; i < k; ++i) {
            queue.offer(input[i]);
        }
        //因为是最大堆，也就是堆顶的元素是堆中最大的，遍历数组后面元素的时候，
        //如果当前元素比堆顶元素小，就把堆顶元素给移除，然后再把当前元素放到堆中，
        for (int i = k; i < input.length; ++i) {
            if (queue.peek() > input[i]) {
                queue.poll();
                queue.offer(input[i]);
            }
        }
        //最后再把堆中元素转化为数组
        for (int i = 0; i < k; ++i) {
            res.add(queue.poll());
        }
        return res;
    }

    ArrayList<Integer> res = new ArrayList<>();


    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        if (input == null || input.length == 0 || k > input.length || k <= 0) {
            return res;
        }

        int left = 0;
        int right = input.length - 1;
        int index = partition(input, left, right);
        while (index != k - 1) {
            if (index > (k - 1)) {
                right = index - 1;
                index = partition(input, left, right);
            } else {
                left = index + 1;
                index = partition(input, left, right);
            }
        }

        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }

        Collections.sort(res);
        return res;
    }

    public int partition(int[] array, int left, int right) {
        int len = array.length;
        if (left < 0 || right > len) {
            return -1;
        }
        int mid = array[right];
        int start = left;
        for (int i = start; i < right; i++) {
            if (array[i] < mid) {
                if (i != start) {
                    swapArray(array, i, start);
                }
                start++;
            }
        }
        swapArray(array, start, right);
        return start;
    }

    private void swapArray(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
