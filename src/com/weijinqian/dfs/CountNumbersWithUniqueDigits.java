package com.weijinqian.dfs;

public class CountNumbersWithUniqueDigits {

    /**
     * 357. 统计各位数字都不同的数字个数
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int cnt_n = 10;
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (cnt_n - i);
        }
        cnt_n = 9;
        int res_1 = 1;
        for (int i = 0; i < (n - 1); i++) {
            res_1 *= (cnt_n - i);
        }
        // 三位数字：A10 3 - A9 2
        return res - res_1 + countNumbersWithUniqueDigits(n - 1);
    }
}
