package com.leetcode.problems.lc154;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArrayII {

	class Solution {
		public int findMin(int[] nums) {
			for (int i = nums.length - 1; i > 0; i--) {
				if (nums[i] < nums[i - 1]) {
					return nums[i];
				}
			}
			return nums[0];
		}
	}

}
