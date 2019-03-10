package com.algorithm.playground.leetcode.problems.lc400.lc410.lc410;

/**
 * https://leetcode.com/problems/split-array-largest-sum/description/
 */
public class SplitArrayLargestSum {

	class Solution {
		public int splitArray(int[] nums, int m) {
			int max = 0, sum = 0;
			for (int i : nums) {
				max = Math.max(max, i);
				sum += i;
			}

			if (m == 1) {
				return sum;
			}

			int left = max;
			int right = sum;

			while (left < right) {
				int middle = (left + right) / 2;
				if (iaValid(middle, nums, m)) {
					right = middle;
				} else {
					left = middle + 1;
				}
			}

			return left;
		}

		private boolean iaValid(int upperBound, int[] nums, int m) {
			int count = 1;
			int sum = 0;
			for (int i : nums) {
				sum += i;
				if (sum > upperBound) {
					sum = i;
					count++;
					if (count > m) {
						return false;
					}
				}
			}
			return true;
		}

	}

}
