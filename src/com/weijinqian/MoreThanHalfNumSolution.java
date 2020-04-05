package com.weijinqian;

public class MoreThanHalfNumSolution {

    /**
     * 选择出超出一半个数的数字
     * 思路就是每次通过partition招到处于中间位置的数字，这样呢，再判断当前数字的合理性
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int mid = array.length / 2;
        int left = 0;
        int right = array.length - 1;
        int index = partition(array, left, right);
        while (index != mid) {
            if (index > mid) {
                right = index - 1;
                index = partition(array, left, right);
            } else {
                left = index + 1;
                index = partition(array, left, right);
            }
        }

        int res = array[index];
        if (checkMoreThanHalfNum(array, res)) {
            return res;
        }
        return 0;
    }

    private boolean checkMoreThanHalfNum(int[] array, int res) {
        int len = array.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == res) {
                sum++;
            }

        }
        if (sum > (len * 1.0 / 2)) {
            return true;
        }
        return false;
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
