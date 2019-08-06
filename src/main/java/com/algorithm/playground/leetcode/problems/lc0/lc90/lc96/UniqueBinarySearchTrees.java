package com.algorithm.playground.leetcode.problems.lc0.lc90.lc96;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 */
public class UniqueBinarySearchTrees {

	class Solution {

		public int numTrees(int n) {
			return dp(n, new int[n + 1]);
		}

		private int dp(int n, int[] cache) {
			if (n == 1 || n == 0) {
				return 1;
			} else if (cache[n] != 0) {
				return cache[n];
			} else {
				int sum = 0;
				for (int i = 0; i < n; i++) {
					sum += dp(i, cache) * dp(n - i - 1, cache);
				}
				return cache[n] = sum;
			}
		}

	}

}
