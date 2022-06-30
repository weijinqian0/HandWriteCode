package com.weijinqian.other;

public class DuplicateSolution {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        int index = 0;
        while (index < length) {
            if (index == numbers[index]) {
                index++;
            } else {
                int tmp = numbers[index];
                // 要去的位置和该位置存的值比较一下，是否相等，相等则重复，不等就交换
                if (tmp == numbers[tmp]) {
                    duplication[0] = tmp;
                    return true;
                } else {
                    numbers[index] = numbers[tmp];
                    numbers[tmp] = tmp;
                }
            }
        }
        return false;
    }
}
