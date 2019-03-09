package com.algorithm.playground.leetcode.problems.bitmanipulation.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 */
public class Subsets {

	class Solution {
		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			dfs(nums, 0, new ArrayList<>(), result);
			return result;
		}

		private void dfs(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result) {
			if (idx == nums.length) {
				result.add(new ArrayList<>(curr));
				return;
			}
			dfs(nums, idx + 1, curr, result);
			curr.add(nums[idx]);
			dfs(nums, idx + 1, curr, result);
			curr.remove(curr.size() - 1);
		}
	}

}
