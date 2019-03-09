package com.algorithm.playground.leetcode.problems.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 */
public class MinimumIncrementToMakeArrayUnique {

	class Solution {
		public int minIncrementForUnique(int[] A) {
			Map<Integer, Integer> counts = new HashMap<>();
			int min = Integer.MAX_VALUE, max = -1;
			for (int i : A) {
				counts.put(i, counts.getOrDefault(i, 0) + 1);
				min = Math.min(min, i);
				max = Math.max(max, i);
			}
			int count = 0, curr = 0;
			for (int i = min; i <= max; i++) {
				curr += counts.getOrDefault(i, 0) - 1;
				curr = Math.max(curr, 0);
				count += curr;
			}
			curr = Math.max(curr - 1, 0);
			count += (1 + curr) / 2. * curr;
			return count;
		}
	}

}
