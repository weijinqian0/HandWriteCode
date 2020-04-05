package com.weijinqian;

import java.util.ArrayList;
import java.util.Collections;

public class GetLeastNumbersSolution {
    ArrayList<Integer> res = new ArrayList<>();


    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
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
