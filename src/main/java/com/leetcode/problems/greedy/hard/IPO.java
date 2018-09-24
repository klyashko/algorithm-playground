package com.leetcode.problems.greedy.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/ipo/description/
 */
public class IPO {

	class Solution {
		public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] p) -> p[1]).reversed());
			int max = 0;
			for (int i = 0; i < Profits.length; i++) {
				int cap = Capital[i];
				if (!map.containsKey(cap)) {
					map.put(cap, new ArrayList<>());
				}
				map.get(cap).add(Profits[i]);
				max = Math.max(max, cap);
			}
			fill(queue, map, 0, W + 1, max);
			int prev = W + 1;
			for (int i = 0; i < k && !queue.isEmpty(); i++) {
				int[] curr = queue.poll();
				//noinspection ConstantConditions
				W += curr[1];
				fill(queue, map, prev, W + 1, max);
				prev = W + 1;
			}
			return W;
		}

		private void fill(Queue<int[]> queue, Map<Integer, List<Integer>> map, int from, int to, int max) {
			for (int i = from; i < Math.min(to, max + 1); i++) {
				List<Integer> l = map.getOrDefault(i, Collections.emptyList());
				for (int p : l) {
					queue.offer(new int[]{i, p});
				}
			}
		}
	}

}
