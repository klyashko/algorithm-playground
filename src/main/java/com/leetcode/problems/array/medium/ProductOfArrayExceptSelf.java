package com.leetcode.problems.array.medium;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductOfArrayExceptSelf {

	public class Solution {
		public int[] productExceptSelf(int[] nums) {
			int[] result = new int[nums.length];
			int productOfAll = 1;
			int zeros = 0;
			for (int i : nums) {
				if (i != zeros) {
					productOfAll *= i;
				} else {
					zeros++;
				}
			}
			if (zeros > 1) {
				return result;
			}
			for (int i = 0; i < nums.length; i++) {
				if (zeros == 1 && nums[i] != 0) {
					continue;
				} else if (zeros == 1 && nums[i] == 0) {
					result[i] = productOfAll;
				} else {
					result[i] = productOfAll / nums[i];
				}
			}
			return result;
		}
	}

}
