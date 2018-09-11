package com.leetcode.problems.depthfirstsearch.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/description/
 */
public class SumOfDistancesInTree {

	class Solution {
		public int[] sumOfDistancesInTree(int N, int[][] edges) {
			if (edges.length == 0) {
				return new int[N];
			}
			int[] ans = new int[N];
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int[] edge : edges) {
				put(map, edge[0], edge[1]);
				put(map, edge[1], edge[0]);
			}

			for (int i = 0; i < N; i++) {
				int[] values = new int[N];
				boolean[] seen = new boolean[N];
				seen[i] = true;
				dfs(map, i, 0, values, seen);

				for (int j : values) {
					ans[i] += j;
				}
			}

			return ans;
		}

		private void put(Map<Integer, List<Integer>> map, int key, int val) {
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(val);
		}

		private void dfs(Map<Integer, List<Integer>> edges, int curr, int depth, int[] values, boolean[] seen) {
			values[curr] = depth;

			for (Integer i : edges.get(curr)) {
				if (seen[i]) {
					continue;
				}
				seen[i] = true;
				dfs(edges, i, depth + 1, values, seen);
			}
		}
	}

}
