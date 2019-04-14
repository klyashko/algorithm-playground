package com.algorithm.playground.leetcode.problems.lc200.lc280.lc287;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindTheDuplicateNumber {

	class Solution {
		public int findDuplicate(int[] nums) {
			Arrays.sort(nums);
			for (int i = 1; i < nums.length; i++) {
				if (nums[i - 1] == nums[i]) {
					return nums[i];
				}
			}
			return 0;
		}
	}

	class PigeonholeSolution {
		public int findDuplicate(int[] nums) {
			int slow = nums[0];
			int fast = nums[0];

			do {
				slow = nums[slow];
				fast = nums[nums[fast]];
			} while (slow != fast);

			int idx1 = nums[0];
			int idx2 = slow;

			while (idx1 != idx2) {
				idx1 = nums[idx1];
				idx2 = nums[idx2];
			}
			return idx1;
		}
	}

}
