package com.algorithm.playground.leetcode.problems.bitmanipulation.easy;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits/description/
 */
public class BinaryNumberWithAlternatingBits {

	class Solution {
		public boolean hasAlternatingBits(int n) {
			int prev = n % 2;
			n /= 2;

			while (n > 0) {
				if (n % 2 == prev) {
					return false;
				}
				prev = n % 2;
				n /= 2;
			}
			return true;
		}
	}

}
