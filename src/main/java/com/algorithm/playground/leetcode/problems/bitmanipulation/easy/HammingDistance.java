package com.algorithm.playground.leetcode.problems.bitmanipulation.easy;

/**
 * https://leetcode.com/problems/hamming-distance/description/
 */
public class HammingDistance {

	class Solution {
		public int hammingDistance(int x, int y) {
			int count = 0;
			for (; x != 0 || y != 0; x /= 2, y /= 2) {
				if (x % 2 != y % 2) {
					count++;
				}
			}

			return count;
		}
	}

	class FastSolution {
		public int hammingDistance(int x, int y) {
			return Integer.bitCount(x ^ y);
		}
	}

}
