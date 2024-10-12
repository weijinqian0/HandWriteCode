package com.weijinqian.dfs;

import java.util.ArrayList;
import java.util.*;

public class MaxNum {
    public static boolean flag = false;
    public static StringBuilder res = new StringBuilder();
    public static int maxValue = 0;

    public static void main(String[] args) {
        // 这个必须得是倒序才对
        Integer[] arr = new Integer[]{3, 2, 1};
        Arrays.sort(arr, Collections.reverseOrder());
        int[] curArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            curArr[i] = arr[i];
        }
        int n = 23121;
        System.out.println(getMaxNumber(curArr, n));
    }

    public static int getMaxNumber(int[] arr, int n) {
        int[] nArray = parseInteger(n);
        maxValue = maxNum(arr);
        StringBuilder cur = new StringBuilder();
        cur.append("0");
        if (DFS(arr, nArray, 0, n, cur)) {
            return Integer.parseInt(res.toString());
        }
        return -1;

    }

    public static int maxNum(int[] arr) {
        int tmp = 0;
        for (int j : arr) {
            if (j > tmp) {
                tmp = j;
            }
        }
        return tmp;
    }

    public static int[] parseInteger(int n) {
        List<Integer> arrays = new ArrayList<>();

        while (n != 0) {
            int cur = n % 10;
            arrays.add(cur);
            n = n / 10;
        }
        int[] res = new int[arrays.size()];
        for (int i = arrays.size() - 1, j = 0; i >= 0; i--, j++) {
            res[j] = arrays.get(i);
        }
        return res;

    }

    public static boolean DFS(int[] arr, int[] nArray, int p, int num, StringBuilder cur) {
        if (p >= nArray.length) {
            if (Integer.parseInt(cur.toString()) < num) {
                res = new StringBuilder(cur);
                return true;
            }
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                cur.append(maxValue);
            } else {
                if (arr[i] > nArray[p]) {
                    continue;
                }
                if (arr[i] < nArray[p]) {
                    flag = true;
                }
                cur.append(arr[i]);
            }
            if (DFS(arr, nArray, p + 1, num, cur)) {
                return true;
            }
            cur.deleteCharAt(cur.length() - 1);
        }
        return false;
    }
}
