package com.weijinqian.other;

public class MultiplySolution {

    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        int len = A.length;
        int[] B = new int[len];

        int res = 1;
        for (int i = 0; i < len; i++) {
            B[i] = res;
            res *= A[i];
        }

        res = 1;
        for (int i = len - 1; i >= 0; i--) {
            B[i] *= res;
            res *= A[i];
        }
        return B;
    }
}
