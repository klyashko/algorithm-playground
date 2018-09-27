package com.leetcode.problems.graph.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/redundant-connection/description/
 */
@SuppressWarnings("ConstantConditions")
public class RedundantConnection {

	class Solution {
		public int[] findRedundantConnection(int[][] edges) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int[] edge : edges) {
				if (!map.containsKey(edge[0])) {
					map.put(edge[0], new ArrayList<>());
				}
				map.get(edge[0]).add(edge[1]);

				if (!map.containsKey(edge[1])) {
					map.put(edge[1], new ArrayList<>());
				}
				map.get(edge[1]).add(edge[0]);
			}
			Set<Integer> cycle = cycle(map);
			for (int i = edges.length - 1; i >= 0; i--) {
				int[] edge = edges[i];
				if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
					return edge;
				}
			}
			return null;
		}

		private Set<Integer> cycle(Map<Integer, List<Integer>> edges) {
			Set<Integer> seen = new HashSet<>();
			Queue<int[]> queue = new ArrayDeque<>();
			// [curr, from]
			queue.add(new int[]{1, 0});
			seen.add(1);
			Integer from = null;
			while (!queue.isEmpty() && from == null) {
				int[] curr = queue.poll();
				for (Integer next : edges.get(curr[0])) {
					if (seen.add(next)) {
						queue.offer(new int[]{next, curr[0]});
					} else if (!next.equals(curr[1])) {
						from = next;
					}
				}
			}

			for (Integer next : edges.get(from)) {
				seen.clear();
				seen.add(next);
				//noinspection ConstantConditions
				if (dfs(from, next, from, seen, edges)) {
					break;
				}
			}

			return seen;
		}

		private boolean dfs(int from, int curr, int to, Set<Integer> cycle, Map<Integer, List<Integer>> edges) {
			if (curr == to) {
				return true;
			}
			for (Integer next : edges.get(curr)) {
				if (next != from) {
					cycle.add(next);
					if (dfs(curr, next, to, cycle, edges)) {
						return true;
					}
					cycle.remove(next);
				}
			}
			return false;
		}
	}

}
