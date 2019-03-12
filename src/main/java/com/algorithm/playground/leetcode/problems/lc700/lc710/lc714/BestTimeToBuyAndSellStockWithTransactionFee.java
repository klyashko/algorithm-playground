package com.algorithm.playground.leetcode.problems.lc700.lc710.lc714;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int profit = 0, hold = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                profit = Math.max(profit, hold + prices[i] - fee);
                hold = Math.max(hold, profit - prices[i]);
            }
            return profit;
        }
    }

}
