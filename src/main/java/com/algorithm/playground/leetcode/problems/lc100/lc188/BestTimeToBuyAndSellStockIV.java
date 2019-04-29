package com.algorithm.playground.leetcode.problems.lc100.lc188;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIV {

	class Solution {

		private int[][] dp;

		public int maxProfit(int k, int[] prices) {
			if (k >= prices.length / 2) {
				int profit = 0;
				for (int i = 1; i < prices.length; i++) {
					profit += Math.max(0, prices[i] - prices[i - 1]);
				}
				return profit;
			}
			dp = new int[k + 1][prices.length];
			for (int[] row : dp) {
				Arrays.fill(row, -1);
			}
			return maxProfit(prices, 0, k);
		}

		private int maxProfit(int[] prices, int idx, int k) {
			if (idx >= prices.length - 1 || k == 0) {
				return 0;
			} else if (dp[k][idx] != -1) {
				return dp[k][idx];
			} else {
				int max = 0;
				int minBuy = Integer.MAX_VALUE;
				for (int i = idx; i < prices.length; i++) {
					int curr = prices[i];
					if (curr < minBuy) {
						minBuy = curr;
						for (int j = i + 1; j < prices.length; j++) {
							int diff = prices[j] - curr;
							if (diff > 0) {
								diff += maxProfit(prices, j + 1, k - 1);
								max = Math.max(max, diff);
							}
						}
					}
				}
				dp[k][idx] = max;
				return max;
			}
		}
	}

}
