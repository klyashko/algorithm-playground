package com.leetcode.problems.heap.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/description/
 */
public class MinimumNumberOfRefuelingStops {

	class Solution {
		public int minRefuelStops(int target, int startFuel, int[][] stations) {
			if (startFuel >= target) {
				return 0;
			}
			Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] s) -> s[1]).reversed());
			int idx = put(queue, stations, 0, startFuel);
			int current = startFuel;
			int count = 0;

			while (!queue.isEmpty()) {
				int[] station = queue.poll();
				count++;
				//noinspection ConstantConditions
				current += station[1];
				if (current >= target) {
					return count;
				}
				idx = put(queue, stations, idx, current);
			}

			return -1;
		}

		private int put(Queue<int[]> queue, int[][] stations, int idx, int limit) {
			for (; idx < stations.length; idx++) {
				int[] station = stations[idx];
				if (station[0] > limit) {
					break;
				}
				queue.offer(station);
			}
			return idx;
		}
	}

}
