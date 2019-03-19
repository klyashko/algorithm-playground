package com.algorithm.playground.leetcode.problems.lc500.lc500.lc502;

import java.util.*;

/**
 * https://leetcode.com/problems/ipo/description/
 */
public class IPO {

	class Solution {
		public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
			TreeMap<Integer, List<Integer>> map = new TreeMap<>();
			Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] p) -> p[1]).reversed());
			for (int i = 0; i < Profits.length; i++) {
				int cap = Capital[i];
				if (!map.containsKey(cap)) {
					map.put(cap, new ArrayList<>());
				}
				map.get(cap).add(Profits[i]);
			}
			fill(queue, map, W);
			for (int i = 0; i < k && !queue.isEmpty(); i++) {
				int[] curr = queue.poll();
				W += curr[1];
				fill(queue, map, W);
			}
			return W;
		}

		private void fill(Queue<int[]> queue, TreeMap<Integer, List<Integer>> map, int to) {
			if (!map.isEmpty()) {
				int until = Math.min(to, map.lastKey()) + 1;
				Map<Integer, List<Integer>> tmp = map.headMap(until);
				Iterator<Integer> iterator = tmp.keySet().iterator();
				while (iterator.hasNext()) {
					Integer capital = iterator.next();
					List<Integer> l = tmp.getOrDefault(capital, Collections.emptyList());
					for (int profit : l) {
						queue.offer(new int[]{capital, profit});
					}
					iterator.remove();
				}
			}
		}
	}

}
