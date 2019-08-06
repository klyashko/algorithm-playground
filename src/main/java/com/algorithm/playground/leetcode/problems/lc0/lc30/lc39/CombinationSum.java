package com.algorithm.playground.leetcode.problems.lc0.lc30.lc39;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum {

	class Solution {

		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			return dp(candidates, target, 0, 0, new ArrayList<>(), new ArrayList<>());
		}


		private List<List<Integer>> dp(int[] candidates, int target, int idx, int sum, List<Integer> curr, List<List<Integer>> result) {
			if (sum == target) {
				result.add(new ArrayList<>(curr));
			} else if (sum < target && idx < candidates.length) {
				int count = 0;
				while (sum <= target) {
					dp(candidates, target, idx + 1, sum, curr, result);
					sum += candidates[idx];
					curr.add(candidates[idx]);
					count++;
				}

				for (int i = 0; i < count; i++) {
					curr.remove(curr.size() - 1);
				}
			}
			return result;
		}
	}

}
