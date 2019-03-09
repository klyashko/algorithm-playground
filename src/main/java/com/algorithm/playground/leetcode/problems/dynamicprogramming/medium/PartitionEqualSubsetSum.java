package com.algorithm.playground.leetcode.problems.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {

	class Solution {
		public boolean canPartition(int[] nums) {
			int sum = 0, max = 0;
			for (int i : nums) {
				sum += i;
				max = Math.max(max, i);
			}
			if (sum % 2 == 1 || max > sum / 2) {
				return false;
			} else if (max == sum / 2) {
				return true;
			}
			Arrays.sort(nums);
			return sum(nums, nums.length - 1, 0, sum / 2);
		}

		public boolean sum(int[] nums, int idx, int curr, int target) {
			if (idx == -1) {
				return curr == target;
			} else if (curr > target) {
				return false;
			} else if (curr == target) {
				return true;
			}
			return sum(nums, idx - 1, curr + nums[idx], target) || sum(nums, idx - 1, curr, target);
		}
	}

}
