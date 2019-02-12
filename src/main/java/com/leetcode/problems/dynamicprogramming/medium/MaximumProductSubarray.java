package com.leetcode.problems.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

	class Solution {
		public int maxProduct(int[] nums) {
			int prev_max = nums[0], prev_min = nums[0], ans = nums[0];

			for (int i = 1; i < nums.length; i++) {
				int max = max(prev_max * nums[i], prev_min * nums[i], nums[i]);
				int min = min(prev_max * nums[i], prev_min * nums[i], nums[i]);

				ans = Math.max(ans, max);

				prev_max = max;
				prev_min = min;
			}

			return ans;
		}

		private int min(int a, int b, int c) {
			return Math.min(Math.min(a, b), c);
		}

		private int max(int a, int b, int c) {
			return Math.max(Math.max(a, b), c);
		}
	}

	class VectorSolution {
		public int maxProduct(int[] nums) {
			int[] col = new int[nums.length];
			Arrays.fill(col, 1);

			int max = Integer.MIN_VALUE;
			for (int c = 0; c < nums.length; c++) {
				for (int r = 0; r <= c; r++) {
					col[r] *= nums[c];
					max = Math.max(col[r], max);
				}
			}

			return max;
		}
	}

}
