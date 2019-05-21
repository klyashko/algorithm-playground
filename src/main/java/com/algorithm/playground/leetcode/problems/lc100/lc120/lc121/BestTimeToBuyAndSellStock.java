package com.algorithm.playground.leetcode.problems.lc100.lc120.lc121;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class BestTimeToBuyAndSellStock {

	class Solution {
		public int maxProfit(int[] prices) {
			int minPrice = Integer.MAX_VALUE, profit = 0;
			for (int price : prices) {
				minPrice = Math.min(minPrice, price);
				profit = Math.max(profit, price - minPrice);
			}
			return profit;
		}
	}

}
