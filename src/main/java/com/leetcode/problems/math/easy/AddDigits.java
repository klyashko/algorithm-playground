package com.leetcode.problems.math.easy;

/**
 * https://leetcode.com/problems/add-digits/description/
 */
public class AddDigits {

	class RecursiveSolution {
		public int addDigits(int num) {
			if (num < 10) {
				return num;
			}
			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			return addDigits(sum);
		}
	}

	class Solution {
		public int addDigits(int num) {
			if (num < 10) {
				return num;
			}
			int mode = num % 9;
			return mode == 0 ? 9 : mode;
		}
	}

}
