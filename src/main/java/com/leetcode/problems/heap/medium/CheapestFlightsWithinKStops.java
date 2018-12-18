package com.leetcode.problems.heap.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {

	class Solution {
		public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
			if (src == dst) {
				return 0;
			}
			Map<Integer, List<int[]>> nodes = new HashMap<>();
			for (int[] f : flights) {
				int from = f[0];
				f[0] = from == src ? 1 : 0;
				if (!nodes.containsKey(from)) {
					nodes.put(from, new ArrayList<>());
				}
				nodes.get(from).add(f);
			}

			int max = dfs(nodes, Integer.MAX_VALUE, 0, src, dst, K, new boolean[n]);
			return max != Integer.MAX_VALUE ? max : -1;
		}

		private int dfs(Map<Integer, List<int[]>> nodes, int max, int sum, int curr, int dst, int K, boolean[] seen) {
			if (curr == dst) {
				return sum;
			} else if (K == -1) {
				return max;
			} else {
				for (int[] next : nodes.getOrDefault(curr, Collections.emptyList())) {
					if (sum + next[2] < max && !seen[next[1]]) {
						seen[next[1]] = true;
						max = dfs(nodes, max, sum + next[2], next[1], dst, K - 1, seen);
						seen[next[1]] = false;
					}
				}
			}
			return max;
		}
	}

}
