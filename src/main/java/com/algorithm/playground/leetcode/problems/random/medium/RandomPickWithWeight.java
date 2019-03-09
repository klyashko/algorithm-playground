package com.algorithm.playground.leetcode.problems.random.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/random-pick-with-weight/description/
 */
public class RandomPickWithWeight {

	public static Solution solution(int[] w) {
		return new RandomPickWithWeight().create(w);
	}

	private Solution create(int[] w) {
		return new Solution(w);
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(w);
	 * int param_1 = obj.pickIndex();
	 */
	class Solution {

		private int[] sums;
		private int total;
		private Random rnd;

		public Solution(int[] w) {
			rnd = new Random();
			sums = new int[w.length];
			int sum = 0;
			for (int i = 0; i < w.length; i++) {
				sum += w[i];
				sums[i] = sum;
			}
			total = sum;
		}

		public int pickIndex() {
			int weight = rnd.nextInt(total) + 1;
			int idx = Arrays.binarySearch(sums, weight);
			if (idx < 0) {
				return -idx - 1;
			} else {
				return idx;
			}
		}
	}

}
