package com.algorithm.playground.leetcode.problems.lc0.lc35;

/**
 * https://leetcode.com/problems/search-insert-position/description/
 */
@SuppressWarnings("Duplicates")
public class SearchInsertPosition {

	class Solution {
		public int searchInsert(int[] nums, int target) {
			int l = 0, r = nums.length;
			while (l < r) {
				int mid = l + (r - l) / 2;
				if (nums[mid] < target) {
					l = mid + 1;
				} else {
					r = mid;
				}
			}
			return l;
		}
	}

}
