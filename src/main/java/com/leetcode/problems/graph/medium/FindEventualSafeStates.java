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
			int[] colors = new int[graph.length];
			for (int i = graph.length - 1; i >= 0; i--) {
				if (dfs(graph, colors, cache, i)) {
					result.add(0, i);
				}
			}

			return result;
		}

		private boolean dfs(int[][] edges, int[] colors, boolean[] cache, int curr) {
			if (cache[curr] || colors[curr] == 2) {
				return true;
			} else if (colors[curr] == 1) {
				return false;
			}

			colors[curr] = 1;
			for (int e : edges[curr]) {
				if (colors[e] == 1 || !dfs(edges, colors, cache, e)) {
					return false;
				}
			}
			colors[curr] = 2;
			cache[curr] = true;
			return true;
		}
	}

}
