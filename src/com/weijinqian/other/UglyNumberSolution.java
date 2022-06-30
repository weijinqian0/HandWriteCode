package com.weijinqian.other;

public class UglyNumberSolution {

    /**
     * 维护三个指针，分别表示当前应该乘2，3，5的元素的下标
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] array = new int[index];
        array[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < index; i++) {
            int minValue = Math.min(array[t2] * 2, Math.min(array[t3] * 3, array[t5] * 5));
            array[i] = minValue;
            if (minValue == array[t2] * 2) {
                t2++;
            }
            if (minValue == array[t3] * 3) {
                t3++;
            }
            if (minValue == array[t5] * 5) {
                t5++;
            }
        }
        return array[index - 1];
    }
}
