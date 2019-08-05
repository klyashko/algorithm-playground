package com.algorithm.playground.leetcode.problems.lc300.lc300.lc309;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */
public class BestTimeToBuyAndSellStockWithCooldown {

	class Solution {

		public int maxProfit(int[] prices) {
			int[] cache = new int[prices.length];
			Arrays.fill(cache, -1);
			return dp(prices, 0, cache);
		}

		private int dp(int[] prices, int idx, int[] cache) {
			if (idx > prices.length - 1) {
				return 0;
			} else if (cache[idx] != -1) {
				return cache[idx];
			} else {
				int max = 0;
				int min = Integer.MAX_VALUE;
				for (int buy = idx; buy < prices.length; buy++) {
					int buyPrice = prices[buy];
					if (buyPrice < min) {
						min = buyPrice;
						for (int sell = buy + 1; sell < prices.length; sell++) {
							int sellPrice = prices[sell];
							int diff = sellPrice - buyPrice;
							if (diff > 0) {
								max = Math.max(max, diff + dp(prices, sell + 2, cache));
							}
						}
					}
				}
				cache[idx] = max;
				return max;
			}
		}

	}

}
