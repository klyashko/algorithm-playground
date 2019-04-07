package com.algorithm.playground.leetcode.problems.lc600.lc690.lc698;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 */
public class PartitionToKEqualSumSubsets {

	class Solution {
		public boolean canPartitionKSubsets(int[] nums, int k) {
			int sum = 0;
			for (int i : nums) {
				sum += i;
			}
			if (sum % k != 0) {
				return false;
			}
			int target = sum / k;
			Arrays.sort(nums);
			int idx = nums.length - 1;
			if (nums[idx] > target) {
				return false;
			}
			while (nums[idx] == target) {
				idx--;
				k--;
			}
			return backtracking(new int[k], nums, idx, target);
		}

		private boolean backtracking(int[] sums, int[] nums, int idx, int target) {
			if (idx == -1) {
				return true;
			}
			for (int i = 0; i < sums.length; i++) {
				if (sums[i] + nums[idx] <= target) {
					sums[i] += nums[idx];
					if (backtracking(sums, nums, idx - 1, target)) {
						return true;
					}
					sums[i] -= nums[idx];
				}
				if (sums[i] == 0) {
					return false;
				}
			}
			return false;
		}

	}

}
