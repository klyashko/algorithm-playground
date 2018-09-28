package com.leetcode.problems.graph.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 */
public class FindEventualSafeStates {

	class Solution {
		public List<Integer> eventualSafeNodes(int[][] graph) {
			List<Integer> result = new ArrayList<>();
			boolean[] cache = new boolean[graph.length];
			for (int i = graph.length - 1; i >= 0; i--) {
				dfs(graph, new int[graph.length], cache, i);
			}

			for (int i = 0; i < cache.length; i++) {
				if (cache[i]) {
					result.add(i);
				}
			}

			return result;
		}

		private boolean dfs(int[][] edges, int[] colors, boolean[] cache, int curr) {
			if (edges[curr].length == 0 || cache[curr]) {
				cache[curr] = true;
				return true;
			}

			colors[curr] = 1;
			for (int e : edges[curr]) {
				if (colors[e] == 0) {
					if (!dfs(edges, colors, cache, e)) {
						return false;
					}
				} else if (colors[e] == 1) {
					return false;
				}
			}
			colors[curr] = 2;
			cache[curr] = true;
			return true;
		}
	}

}
