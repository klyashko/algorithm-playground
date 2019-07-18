package com.algorithm.playground.leetcode.problems.lc1000.lc1000.lc1029;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/two-city-scheduling/
 */
public class TwoCityScheduling {

	class Solution {
		public int twoCitySchedCost(int[][] costs) {
			Arrays.sort(costs, Comparator.comparingInt((int[] i) -> Math.abs(i[0] - i[1])).reversed());

			int a = costs.length >> 1, b = a, cost = 0;

			for (int[] curr : costs) {
				if (b == 0 || (curr[0] < curr[1] && a > 0)) {
					cost += curr[0];
					a--;
				} else {
					cost += curr[1];
					b--;
				}
			}

			return cost;
		}
	}

}
