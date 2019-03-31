package com.algorithm.playground.leetcode.problems.lc100.lc120.lc123;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStockIII {

	class Solution {
		public int maxProfit(int[] prices) {
			int len = prices.length;
			if (len < 2) {
				return 0;
			}
			int[] maxBefore = new int[len];
			int min = prices[0];
			for (int i = 1; i < len; i++) {
				maxBefore[i] = Math.max(maxBefore[i - 1], prices[i] - min);
				min = Math.min(min, prices[i]);
			}

			int max = prices[len - 1];
			int ret = 0;
			for (int i = len - 2; i >= 0; i--) {
				max = Math.max(prices[i], max);
				ret = Math.max(ret, max - prices[i] + maxBefore[i]);
			}
			return ret;
		}
	}

}
