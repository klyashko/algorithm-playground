package com.algorithm.playground.leetcode.problems.lc500.lc594;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */
public class LongestHarmoniousSubsequence {

	class Solution {
		public int findLHS(int[] nums) {
			Map<Integer, Integer> counts = new HashMap<>();
			for (int i : nums) {
				counts.put(i, counts.getOrDefault(i, 0) + 1);
			}
			int max = 0;
			for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
				Integer next = counts.get(e.getKey() + 1);
				if (next != null) {
					max = Math.max(max, e.getValue() + next);
				}
			}
			return max;
		}
	}

}
