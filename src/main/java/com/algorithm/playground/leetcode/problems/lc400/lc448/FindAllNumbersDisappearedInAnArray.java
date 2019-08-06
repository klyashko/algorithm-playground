package com.algorithm.playground.leetcode.problems.lc400.lc448;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * <p>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 */
public class FindAllNumbersDisappearedInAnArray {

	class Solution {

		public List<Integer> findDisappearedNumbers(int[] nums) {
			for (int i = 0; i < nums.length; i++) {
				int val = i + 1;
				if (nums[i] != val && nums[nums[i] - 1] != nums[i]) {
					swap(nums, i, nums[i] - 1);
					i--;
				}
			}

			List<Integer> ans = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != i + 1) {
					ans.add(i + 1);
				}
			}
			return ans;
		}

		private void swap(int[] nums, int i, int j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}

	}

}
