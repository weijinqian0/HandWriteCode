package com.weijinqian.dfs;

public class CountDigitOne {

    /**
     * 233. 数字 1 的个数
     *
     * @param n
     * @return
     */
    int countDigitOne(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i *= 10) {
            // i表示统计哪一位的1,i == 1个位,i == 10十位,依次类推
            // (n / (i * 10)) * i是上述固定一定出现的1的次数
            // 考虑:
            // 1. n < i, 只要(n / (i * 10)) * i即可
            // 2. i <= x < 2 * i, 还要加上 x - i + 1
            // 3. x >= 2 * i 还要加上i
            // 举个例子,2022,2010-2019还要+10次,2009的话就不要加,2014,就要加2010-2011-2012-2013-2014 = 14 - 10 + 1 = 5个1
            ans += (n / (i * 10)) * i + Math.min(Math.max(n % (i * 10) - i + 1, 0), i);
        }
        return ans;

    }
}
