package com.algorithm.playground.leetcode.problems.lc300.lc320.lc322;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

	class Solution {
		public int coinChange(int[] coins, int amount) {
			return dp(coins, amount, new int[amount + 1]);
		}

		private int dp(int[] coins, int rest, int[] cache) {
			if (rest == 0) {
				return 0;
			} else if (rest < 0) {
				return -1;
			} else if (cache[rest] != 0) {
				return cache[rest];
			} else {
				int ans = -1;
				for (int i = coins.length - 1; i >= 0; i--) {
					int curr = dp(coins, rest - coins[i], cache);
					if (curr != -1) {
						if (ans == -1) {
							ans = curr;
						} else {
							ans = Math.min(ans, curr);
						}
					}
				}
				return cache[rest] = ans == -1 ? ans : ans + 1;
			}
		}

	}

}
