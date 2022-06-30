package com.weijinqian.other;

import java.util.ArrayList;

public class FindNumsAppearOnceSolution {
    /**
     * 思路：
     * 1. 先求出所有数字的异或
     * 2. 再求出异或的其中一位为1，分为两组数字
     * 3. 对两组数字求异或的结果就是结果
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum ^= array[i];
        }

        int cur = 0;
        while (sum != 0) {
            if (sum % 2 == 1) {
                break;
            }
            sum /= 2;
            cur++;
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        int number = (int) Math.pow(2, cur);

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & number) != 0) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }

        int number1 = 0;
        int number2 = 0;
        for (int i = 0; i < list1.size(); i++) {
            number1 ^= list1.get(i);
        }

        for (int i = 0; i < list2.size(); i++) {
            number2 ^= list2.get(i);
        }

        num1[0] = number1;
        num2[0] = number2;

    }
}
