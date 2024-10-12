package com.weijinqian;

public class CoinCount {

    //    有1/2/5/10四种硬币, 希望凑20块钱，硬币可以重复使用，求所有可能实现的方法总数有几种？(5,10,5) 和 (5,5,10)算一种情况
    public static int count_coins(int[] coins, int sumNum) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int len = coins.length;
        int[][] dp = new int[len + 1][sumNum + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sumNum; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 这里为啥是i，是因为这里是完全背包问题，0-1则使用i-1
                    // 在当前背包容量下，当前coins数，有多少种方案
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[len][sumNum];
    }

}
