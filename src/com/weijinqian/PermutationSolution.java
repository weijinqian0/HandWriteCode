package com.weijinqian;

import java.util.ArrayList;
import java.util.Collections;

public class PermutationSolution {

    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return res;
        }
        permutation(new StringBuilder(str), 0);
        Collections.sort(res);
        return res;
    }

    /**
     * 处理一下重复的情况
     *
     * @param str
     * @param cur
     */
    private void permutation(StringBuilder str, int cur) {
        int len = str.length();

        if (cur >= len) {
            res.add(str.toString());
            return;
        }

        for (int i = cur; i < len; i++) {
            // 对于重复的字母则不进行交换
            if (i != cur && str.charAt(i) == str.charAt(cur)) {
                continue;
            }
            swapStr(str, i, cur);
            permutation(str, cur + 1);
            swapStr(str, i, cur);
        }

    }

    private void swapStr(StringBuilder str, int i, int j) {
        char tmp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, tmp);
    }

}
