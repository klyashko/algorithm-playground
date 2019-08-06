package com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1124;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-well-performing-interval/
 * <p>
 * We are given hours, a list of the number of hours worked per day for a given employee.
 * <p>
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 * <p>
 * A well-performing interval is an interval of days for which the number
 * of tiring days is strictly larger than the number of non-tiring days.
 * <p>
 * Return the length of the longest well-performing interval.
 * <p>
 * Constraints:
 * <p>
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 */
public class LongestWellPerformingInterval {

	class Solution {
		public int longestWPI(int[] hours) {
			int max = 0, score = 0;
			Map<Integer, Integer> seen = new HashMap<>();
			for (int i = 0; i < hours.length; i++) {
				score += hours[i] > 8 ? 1 : -1;
				if (score > 0) {
					max = i + 1;
				} else {
					seen.putIfAbsent(score, i);
					Integer prev = seen.get(score - 1);
					if (prev != null) {
						max = Math.max(max, i - prev);
					}
				}
			}
			return max;
		}
	}

}
