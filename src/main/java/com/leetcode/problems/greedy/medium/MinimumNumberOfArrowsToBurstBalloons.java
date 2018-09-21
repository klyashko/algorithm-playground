package com.leetcode.problems.greedy.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 */
public class MinimumNumberOfArrowsToBurstBalloons {

	class Solution {
		public int findMinArrowShots(int[][] points) {
			Arrays.sort(points, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p1[0] - p2[0]);
			int count = 0, idx = 0;
			while (idx < points.length) {
				int[] curr = points[idx++];
				while (idx < points.length && points[idx][0] <= curr[1]) {
					curr[1] = Math.min(curr[1], points[idx][1]);
					idx++;
				}
				count++;
			}
			return count;
		}
	}

}
