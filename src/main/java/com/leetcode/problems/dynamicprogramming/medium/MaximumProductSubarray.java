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
				int max = Math.max(prev_max * nums[i], prev_min * nums[i]);
				max = Math.max(max, nums[i]);

				int min = Math.min(prev_max * nums[i], prev_min * nums[i]);
				min = Math.min(min, nums[i]);

				ans = Math.max(ans, max);

				prev_max = max;
				prev_min = min;
			}

			return ans;
		}
	}

	class Solution_ {
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
