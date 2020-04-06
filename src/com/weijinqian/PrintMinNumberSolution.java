package com.weijinqian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintMinNumberSolution {
    public String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> tmpNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            tmpNumbers.add(numbers[i]);
        }

        Collections.sort(tmpNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (String.valueOf(o1) + o2).compareTo((String.valueOf(o2) + o1));
            }
        });

        StringBuilder tmp = new StringBuilder();
        for (Integer s : tmpNumbers) {
            tmp.append(String.valueOf(s));
        }

        return tmp.toString();
    }
}
