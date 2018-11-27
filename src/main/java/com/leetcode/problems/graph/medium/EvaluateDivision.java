package com.leetcode.problems.graph.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	class Solution {

		public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
			Map<String, Map<String, Double>> graph = new HashMap<>();

			for (int i = 0; i < equations.length; i++) {
				String[] edge = equations[i];
				add(edge[0], edge[1], values[i], graph);
				add(edge[1], edge[0], 1. / values[i], graph);
			}

			double[] ans = new double[queries.length];
			for (int i = 0; i < queries.length; i++) {
				String[] query = queries[i];
				double[] res = new double[]{1.};
				if (dfs(query[0], query[1], res, graph, new HashSet<>())) {
					ans[i] = res[0];
				} else {
					ans[i] = -1;
				}

			}

			return ans;
		}

		private boolean dfs(String from, String to, double[] curr, Map<String, Map<String, Double>> graph, Set<String> seen) {
			if (!graph.containsKey(from)) {
				return false;
			} else if (from.equals(to)) {
				return true;
			}
			Map<String, Double> children = graph.get(from);
			for (String next : children.keySet()) {
				if (seen.add(next)) {
					curr[0] *= children.get(next);
					if (dfs(next, to, curr, graph, seen)) {
						return true;
					}
					curr[0] /= children.get(next);
				}
			}
			return false;
		}

		private void add(String from, String to, double weight, Map<String, Map<String, Double>> graph) {
			if (!graph.containsKey(from)) {
				graph.put(from, new HashMap<>());
			}
			graph.get(from).put(to, weight);
		}
	}

}
