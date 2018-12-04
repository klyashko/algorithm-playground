package com.leetcode.problems.array.medium;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/
 */
public class MinimumIncrementToMakeArrayUnique {

	class Solution {
		public int minIncrementForUnique(int[] A) {
			if (A.length == 0) {
				return 0;
			}
			TreeMap<Integer, Integer> counts = new TreeMap<>();
			for (int i : A) {
				counts.put(i, counts.getOrDefault(i, 0) + 1);
			}
			int count = 0;
			Integer curr = 0;
			for (int i = counts.firstKey(); i <= counts.lastKey(); i++) {
				curr += counts.getOrDefault(i, 0) - 1;
				curr = Math.max(curr, 0);
				count += curr;
			}
			curr -= 1;
			if (curr > 0) {
				count += (1 + curr) / 2. * curr;
			}
			return count;
		}
	}

}
