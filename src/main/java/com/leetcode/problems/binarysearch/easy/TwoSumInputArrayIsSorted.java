package com.leetcode.problems.binarysearch.easy;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumInputArrayIsSorted {

	class Solution {
		public int[] twoSum(int[] numbers, int target) {
			for (int i = 0; i < numbers.length; i++) {
				int t = binarySearch(numbers, target, i);
				if (t != -1) {
					return new int[]{i + 1, t + 1};
				}
			}
			return new int[]{-1, -1};
		}

		private int binarySearch(int[] numbers, int target, int idx) {
			int l = idx + 1, r = numbers.length - 1;
			int curr = numbers[idx];
			while (l < r) {
				int mid = l + (r - l) / 2;
				if (curr + numbers[mid] < target) {
					l = mid + 1;
				} else {
					r = mid;
				}
			}
			return curr + numbers[l] == target ? l : -1;
		}
	}

}
