package com.algorithm.playground.leetcode.problems.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/description/
 */
public class Permutations {

	class Solution {
		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> values = new ArrayList<>();
			backtracking(nums, 0, values);
			return values;
		}

		private void backtracking(int[] nums, int idx, List<List<Integer>> values) {
			if (idx == nums.length - 1) {
				values.add(toArray(nums));
			}
			for (int i = idx; i < nums.length; i++) {
				swap(nums, idx, i);
				backtracking(nums, idx + 1, values);
				swap(nums, idx, i);
			}
		}

		private void swap(int[] nums, int i, int j) {
			int n = nums[i];
			nums[i] = nums[j];
			nums[j] = n;
		}

		private List<Integer> toArray(int[] nums) {
			List<Integer> list = new ArrayList<>(nums.length);
			for (int i : nums) {
				list.add(i);
			}
			return list;
		}
	}

}
