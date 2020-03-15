package com.weijinqian;

public class ReorderPositionSolution {
    public void reOrderArray(int[] array) {
        if (array == null) {
            return;
        }
        if (array.length == 0) {
            return;
        }
        // 要想稳定 考虑使用归并的方式来处理
        int[] newArray = new int[array.length];
        int curIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                newArray[curIdx++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                newArray[curIdx++] = array[i];
            }
        }
        curIdx = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = newArray[curIdx++];
        }

    }
}
