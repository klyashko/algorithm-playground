package com.leetcode.problems.lc400.lc450.lc452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 */
public class MinimumNumberOfArrowsToBurstBalloons {

	class Solution {
		public int findMinArrowShots(int[][] points) {
			Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
			int count = 0;
			for (int idx = 0; idx < points.length; count++) {
				int limit = points[idx++][1];
				while (idx < points.length && points[idx][0] <= limit) {
					limit = Math.min(limit, points[idx++][1]);
				}
			}
			return count;
		}
	}

}
