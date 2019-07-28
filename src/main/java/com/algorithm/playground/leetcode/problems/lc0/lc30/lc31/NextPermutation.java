package com.algorithm.playground.leetcode.problems.lc0.lc30.lc31;

/**
 * https://leetcode.com/problems/next-permutation/
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {

	class Solution {
		public void nextPermutation(int[] nums) {
			int i = nums.length - 2;

			while (i >= 0 && nums[i] >= nums[i + 1]) {
				i--;
			}

			if (i >= 0) {
				int j = nums.length - 1;
				while (j >= 0 && nums[i] >= nums[j]) {
					j--;
				}

				swap(nums, i, j);
			}

			int r = i + 1, s = nums.length - 1;
			while (r < s) {
				swap(nums, r, s);
				r++;
				s--;
			}
		}

		private void swap(int[] nums, int i, int j) {
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
		}
	}

}
