package com.weijinqian;

public class StrToIntSolution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        long sum = 0;
        boolean isMinus = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                sum = sum * 10 + c - '0';
            } else if (c == '-' || c == '+') {
                if (i == 0) {
                    if (c == '-') {
                        isMinus = true;
                    }
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
        if (isMinus) {
            if ((-sum) < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) -sum;
        }
        if (sum > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) sum;
    }
}
