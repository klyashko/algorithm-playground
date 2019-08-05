package com.algorithm.playground.leetcode.problems.lc200.lc279;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/perfect-squares/
 * <p>
 * Given a positive integer n,
 * find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 */
public class PerfectSquares {

	class Solution {

		public int numSquares(int n) {
			Queue<Integer> queue = new ArrayDeque<>();
			boolean[] seen = new boolean[n + 1];
			queue.offer(n);
			seen[n] = true;
			int epoch = 0;

			for (; !queue.isEmpty(); epoch++) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Integer curr = queue.poll();
					//noinspection ConstantConditions
					if (curr == 0) {
						return epoch;
					}
					int max = (int) Math.sqrt(curr);
					for (int next = max; next > 0; next--) {
						int tmp = curr - (next * next);
						if (!seen[tmp]) {
							seen[tmp] = true;
							queue.offer(tmp);
						}
					}
				}
			}

			return epoch;
		}

	}

	class SolutionDP {

		public int numSquares(int n) {
			return dp(n, new int[n + 1]);
		}

		private int dp(int n, int[] cache) {
			if (n == 0) {
				return 0;
			} else if (cache[n] != 0) {
				return cache[n];
			} else {
				int max = (int) Math.sqrt(n);
				int min = n;
				for (int i = max; i > 0; i--) {
					min = Math.min(min, dp(n - (i * i), cache) + 1);
				}
				cache[n] = min;
				return min;
			}
		}

	}

}
