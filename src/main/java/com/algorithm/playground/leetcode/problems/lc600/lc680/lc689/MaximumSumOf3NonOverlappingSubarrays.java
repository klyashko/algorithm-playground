package com.algorithm.playground.leetcode.problems.lc600.lc680.lc689;

/**
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 */
public class MaximumSumOf3NonOverlappingSubarrays {

	class Solution {
		public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
			int[] W = new int[nums.length - k + 1];
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
				if (i >= k) {
					sum -= nums[i - k];
				}
				if (i >= k - 1) {
					W[i - k + 1] = sum;
				}
			}

			int[] left = new int[W.length];
			int max = 0;

			for (int i = 0; i < W.length; i++) {
				if (W[i] > W[max]) {
					max = i;
				}
				left[i] = max;
			}

			int[] right = new int[W.length];
			max = right.length - 1;

			for (int i = right.length - 1; i >= 0; i--) {
				if (W[i] >= W[max]) {
					max = i;
				}
				right[i] = max;
			}

			int[] ans = null;
			for (int j = k; j < W.length - k; j++) {
				int i = left[j - k], g = right[j + k];
				if (ans == null || W[i] + W[j] + W[g] > W[ans[0]] + W[ans[1]] + W[ans[2]]) {
					ans = new int[]{i, j, g};
				}
			}

			return ans;
		}

	}

}
