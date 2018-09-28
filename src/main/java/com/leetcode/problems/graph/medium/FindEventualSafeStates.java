package com.leetcode.problems.graph.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 */
public class FindEventualSafeStates {

	class Solution {
		public List<Integer> eventualSafeNodes(int[][] graph) {
			boolean[] cache = new boolean[graph.length];
			for (int i = graph.length - 1; i >= 0; i--) {
				boolean[] seen = new boolean[graph.length];
				seen[i] = true;
				dfs(graph, seen, cache, i);
			}

			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < cache.length; i++) {
				if (cache[i]) {
					result.add(i);
				}
			}
			return result;
		}

		private boolean dfs(int[][] edges, boolean[] seen, boolean[] cache, int curr) {
			if (edges[curr].length == 0 || cache[curr]) {
				cache[curr] = true;
				return true;
			}

			for (int e : edges[curr]) {
				if (!seen[e]) {
					seen[e] = true;
					if (!dfs(edges, seen, cache, e)) {
						return false;
					}
				} else if (!cache[e]) {
					return false;
				}
			}
			cache[curr] = true;
			return true;
		}
	}

}
