package com.leetcode.problems.dynamic.programming.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeToBuyAndSellStock {

    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int profit = 0;
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;
                } else {
                    if (price - minPrice > profit) {
                        profit = price - minPrice;
                    }
                }
            }
            return profit;
        }
    }

}
