package com.algorithm.playground.leetcode.problems.lc800.lc802;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 */
public class FindEventualSafeStates {

	class Solution {
		public List<Integer> eventualSafeNodes(int[][] graph) {
			List<Integer> result = new ArrayList<>();
			int[] colors = new int[graph.length];
			for (int i = 0; i < graph.length; i++) {
				if (dfs(graph, colors, i)) {
					result.add(i);
				}
			}

			return result;
		}

		private boolean dfs(int[][] edges, int[] colors, int curr) {
			if (colors[curr] > 0) {
				return colors[curr] == 2;
			}

			colors[curr] = 1;
			for (int e : edges[curr]) {
				if (colors[e] == 1 || !dfs(edges, colors, e)) {
					return false;
				}
			}
			colors[curr] = 2;
			return true;
		}
	}

}
