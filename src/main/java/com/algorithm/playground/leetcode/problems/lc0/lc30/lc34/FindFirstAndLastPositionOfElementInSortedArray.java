package com.algorithm.playground.leetcode.problems.lc0.lc30.lc34;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

	class Solution {

		public int[] searchRange(int[] nums, int target) {
			if (nums.length == 0) {
				return new int[]{-1, -1};
			}
			int left = leftBinarySearch(nums, target);
			if (left == -1) {
				return new int[]{-1, -1};
			}
			return new int[]{
					left,
					rightBinarySearch(nums, target)
			};
		}

		private int leftBinarySearch(int[] nums, int target) {
			int le = 0, ri = nums.length - 1;
			while (le <= ri) {
				int mid = (ri - le >> 1) + le;
				if (nums[mid] >= target) {
					ri = mid - 1;
				} else {
					le = mid + 1;
				}
			}
			return le < nums.length && nums[le] == target ? le : -1;
		}

		private int rightBinarySearch(int[] nums, int target) {
			int le = 0, ri = nums.length - 1;
			while (le <= ri) {
				int mid = (ri - le >> 1) + le;
				if (nums[mid] <= target) {
					le = mid + 1;
				} else {
					ri = mid - 1;
				}
			}
			return ri >= 0 && nums[ri] == target ? ri : -1;
		}

	}

}
