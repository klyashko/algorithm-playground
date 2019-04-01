package com.algorithm.playground.leetcode.problems.lc800.lc870.lc871;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/description/
 */
public class MinimumNumberOfRefuelingStops {

	public class Solution {
		public int minRefuelStops(int target, int fuel, int[][] stations) {
			if (fuel >= target) {
				return 0;
			}
			Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			int idx = put(queue, stations, 0, fuel);

			for (int count = 1; !queue.isEmpty(); count++) {
				fuel += queue.poll();
				if (fuel >= target) {
					return count;
				}
				idx = put(queue, stations, idx, fuel);
			}

			return -1;
		}

		private int put(Queue<Integer> queue, int[][] stations, int idx, int limit) {
			for (; idx < stations.length; idx++) {
				int[] station = stations[idx];
				if (station[0] > limit) {
					break;
				}
				queue.offer(station[1]);
			}
			return idx;
		}
	}

}
