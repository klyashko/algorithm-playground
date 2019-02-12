package com.leetcode.problems.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

	class Solution {
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
