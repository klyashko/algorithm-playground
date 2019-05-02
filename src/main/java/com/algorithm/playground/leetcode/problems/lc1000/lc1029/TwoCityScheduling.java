package com.algorithm.playground.leetcode.problems.lc1000.lc1029;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/two-city-scheduling/
 */
public class TwoCityScheduling {

	class Solution {
		public int twoCitySchedCost(int[][] costs) {
			int a = costs.length >> 1;
			int b = a;
			int cost = 0;
			int idx = 0;
			Arrays.sort(costs, Comparator.comparingInt((int[] i) -> Math.abs(i[0] - i[1])).reversed());

			while (a > 0 && b > 0) {
				int[] curr = costs[idx++];
				if (curr[0] < curr[1]) {
					cost += curr[0];
					a--;
				} else {
					cost += curr[1];
					b--;
				}
			}

			while (a > 0) {
				cost += costs[idx++][0];
				a--;
			}

			while (b > 0) {
				cost += costs[idx++][1];
				b--;
			}

			return cost;
		}
	}

}
