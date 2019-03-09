package com.algorithm.playground.leetcode.problems.binarysearch.easy;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumInputArrayIsSorted {

	class Solution {

		public int[] twoSum(int[] numbers, int target) {
			for (int i = numbers.length - 1; i >= 0; i--) {
				if (numbers[i] > target && target > 0) {
					continue;
				}
				int idx1 = binarySearch(numbers, target, i);
				if (idx1 != -1) {
					return new int[]{idx1 + 1, i + 1};
				}
			}
			return new int[]{-1, -1};
		}

		private int binarySearch(int[] numbers, int target, int idx) {
			int l = 0, r = idx - 1;
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
