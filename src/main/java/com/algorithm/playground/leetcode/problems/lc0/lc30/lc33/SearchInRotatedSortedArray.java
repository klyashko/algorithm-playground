package com.algorithm.playground.leetcode.problems.lc0.lc30.lc33;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
@SuppressWarnings("Duplicates")
public class SearchInRotatedSortedArray {

	class Solution {
		public int search(int[] nums, int target) {
			if (nums.length == 0) {
				return -1;
			}
			int pivot = findPivot(nums);
			if (pivot == 0) {
				return binarySearch(nums, target, 0, nums.length - 1);
			} else {
				int left = binarySearch(nums, target, 0, pivot - 1);
				if (left == -1) {
					return binarySearch(nums, target, pivot, nums.length - 1);
				}
				return left;
			}
		}

		private int binarySearch(int[] nums, int target, int le, int ri) {
			while (le <= ri) {
				int mid = (ri - le >> 1) + le;
				if (nums[mid] < target) {
					le = mid + 1;
				} else if (nums[mid] > target) {
					ri = mid - 1;
				} else {
					return mid;
				}
			}
			return -1;
		}

		private int findPivot(int[] nums) {
			int le = 0, ri = nums.length - 1;
			if (nums[le] < nums[ri]) {
				return 0;
			}
			int last = nums[ri];
			while (le <= ri) {
				int mid = (ri - le >> 1) + le;
				if (nums[mid] > last) {
					le = mid + 1;
				} else if (nums[mid] < last) {
					ri = mid - 1;
				} else {
					return mid;
				}
			}
			return le;
		}
	}

}
