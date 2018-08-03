package com.leetcode.problems.array.medium;

/**
 * https://leetcode.com/problems/teemo-attacking/description/
 */
public class TeemoAttacking {

	public class Solution {

		public int findPoisonedDuration(int[] timeSeries, int duration) {
			int time = timeSeries.length * duration;
			for (int i = 0; i < timeSeries.length - 1; i++) {
				time -= Math.max(duration - (timeSeries[i + 1] - timeSeries[i]), 0);
			}
			return time;
		}
	}

}
