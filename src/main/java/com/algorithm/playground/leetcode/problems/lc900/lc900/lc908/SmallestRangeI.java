package com.algorithm.playground.leetcode.problems.lc900.lc900.lc908;

/**
 * https://leetcode.com/problems/smallest-range-i/
 */
public class SmallestRangeI {

	class Solution {
		public int smallestRangeI(int[] A, int K) {
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for (int i : A) {
				min = Math.min(min, i);
				max = Math.max(max, i);
			}
			return Math.max(0, max - min - (K << 1));
		}
	}

}
