package com.weijinqian.dfs;

public class CountNumbersWithUniqueDigits {

    /**
     * 357. 统计各位数字都不同的数字个数
     * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10的n次方 。
     * 示例 1：
     * 输入：n = 2
     * 输出：91
     * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
     * 示例 2：
     * 输入：n = 0
     * 输出：1
     * ————————————————
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
