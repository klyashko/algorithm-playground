package com.algorithm.playground.leetcode.problems.lc700.lc780.lc785;

/**
 * https://leetcode.com/problems/is-graph-bipartite/description/
 */
public class IsGraphBipartite {

	class Solution {
		public boolean isBipartite(int[][] graph) {
			int[] colors = new int[graph.length];
			for (int i = 0; i < graph.length; i++) {
				if (graph[i].length > 0 && colors[i] == 0) {
					if (dfs(graph, colors, i, 1)) {
						return false;
					}
				}
			}
			return true;
		}

		private boolean dfs(int[][] graph, int[] colors, int node, int color) {
			if (colors[node] > 0) {
				return colors[node] != color;
			}
			colors[node] = color;
			int next = color == 1 ? 2 : 1;
			for (int n : graph[node]) {
				if (dfs(graph, colors, n, next)) {
					return true;
				}
			}
			return false;
		}
	}

}
