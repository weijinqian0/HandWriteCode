package com.weijinqian;

//NC135 买卖股票的最好时机(三)
public class MaxProfitSolution {


    /**
     * 限制一次交易次数
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // write code here
        // 当前时刻卖出获取的最大收益
        int maxProfitRes = 0;
        int curMinValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < curMinValue) {
                curMinValue = prices[i];
            }
            if (prices[i] - curMinValue > maxProfitRes) {
                maxProfitRes = prices[i] - curMinValue;
            }
        }
        return maxProfitRes;
    }

    /**
     * 不限制交易次数
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 不限制交易次数，每天可以买卖多次，那么就默认可以获取所有的该赚的利润差
        int maxProfitRes = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfitRes += prices[i] - prices[i - 1];
            }
        }
        return maxProfitRes;
    }

    /**
     * 最多交易两次，同一时间只能交易一次
     * 就是完成遍历两次，前面那个确定好买入点，当前位置作为最大收益获取，后面那个确定好卖出点，当前位置作为做大收益
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int money = prices[0];
        int[] first = new int[n];
        for (int i = 1; i < n; ++i) {
            money = Math.min(money, prices[i]);
            first[i] = Math.max(first[i - 1], prices[i] - money);
        }
        int[] second = new int[n];
        money = prices[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            money = Math.max(money, prices[i]);
            second[i] = Math.max(second[i + 1], money - prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i)
            ans = Math.max(ans, first[i] + second[i]);
        return ans;

    }

    /**
     * 买卖股票的最好时机(四)
     * @param prices
     * @param k
     * @return
     */
    public int maxProfit3 (int[] prices, int k) {
        if (prices.length <= 1) return 0;

        int[] cash = new int[prices.length];
        for (int i = 0; i < k; i++) {
            maxProfitOnePass(prices, cash);
        }

        return cash[cash.length-1];
    }

    public void maxProfitOnePass(int[] prices, int[] cash) {
        // 买
        int maxCash = Integer.MIN_VALUE;
        for (int i = 0; i < cash.length; i++) {
            cash[i] = Math.max(maxCash, cash[i] - prices[i]);
            maxCash = Math.max(maxCash, cash[i]);
        }

        // 卖
        maxCash = Integer.MIN_VALUE;
        for (int i = 0; i < cash.length; i++) {
            cash[i] = Math.max(maxCash, cash[i] + prices[i]);
            maxCash = Math.max(maxCash, cash[i]);
        }
    }
}
