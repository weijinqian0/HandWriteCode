package com.weijinqian;

import java.util.ArrayList;
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
        //如果当前元素比堆顶元素大，就把堆顶元素给移除，然后再把当前元素放到堆中，
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
}
