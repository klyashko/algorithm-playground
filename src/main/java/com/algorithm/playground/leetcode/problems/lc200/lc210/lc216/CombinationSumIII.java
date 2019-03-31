package com.algorithm.playground.leetcode.problems.lc200.lc210.lc216;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/description/
 */
public class CombinationSumIII {

	class Solution {
		public List<List<Integer>> combinationSum3(int k, int n) {
			List<List<Integer>> values = new ArrayList<>();
			backtracking(n, 0, new int[k], 0, 0, values);
			return values;
		}

		private void backtracking(int n, int prev, int[] nums, int sum, int idx, List<List<Integer>> values) {
			if (sum > n || (sum == n && idx < nums.length)) {
				return;
			}
			if (idx == nums.length) {
				if (sum == n) {
					values.add(toArray(nums));
				}
				return;
			}
			for (int i = prev + 1; i < 10; i++) {
				nums[idx] = i;
				backtracking(n, i, nums, sum + i, idx + 1, values);
			}
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
