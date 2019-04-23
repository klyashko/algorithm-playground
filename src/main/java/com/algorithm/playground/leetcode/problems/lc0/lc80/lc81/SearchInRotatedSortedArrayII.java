package com.algorithm.playground.leetcode.problems.lc0.lc80.lc81;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 */
public class SearchInRotatedSortedArrayII {

	class Solution {
		public boolean search(int[] nums, int target) {
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] < nums[i - 1]) {
					return search(nums, target, 0, i) || search(nums, target, i, nums.length);
				}
			}
			return search(nums, target, 0, nums.length);
		}

		private boolean search(int[] nums, int target, int li, int ri) {
			while (li < ri) {
				int mid = (ri - li >> 1) + li;
				if (nums[mid] < target) {
					li = mid + 1;
				} else if (nums[mid] == target) {
					return true;
				} else {
					ri = mid;
				}
			}

			return false;
		}
	}

}
