package com.leetcode.problems.lc310;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class MinimumHeightTrees {

	class Solution {
		public List<Integer> findMinHeightTrees(int n, int[][] edges) {
			if (n == 1) {
				return Collections.singletonList(0);
			}
			int[] degrees = new int[n];
			Map<Integer, Set<Integer>> graph = new HashMap<>();
			for (int[] edge : edges) {
				graph.computeIfAbsent(edge[0], ignored -> new HashSet<>()).add(edge[1]);
				graph.computeIfAbsent(edge[1], ignored -> new HashSet<>()).add(edge[0]);
				degrees[edge[0]]++;
				degrees[edge[1]]++;
			}
			LinkedList<Integer> leafs = new LinkedList<>();
			for (int i = 0; i < degrees.length; i++) {
				if (degrees[i] == 1) {
					leafs.add(i);
				}
			}

			List<Integer> next = new LinkedList<>();

			while (graph.size() > 2) {
				for (Integer curr : leafs) {
					degrees[curr] = 0;
					Set<Integer> parents = graph.remove(curr);
					if (parents != null) {
						for (Integer parent : parents) {
							degrees[parent]--;
							if (degrees[parent] == 1) {
								next.add(parent);
							}
							graph.get(parent).remove(curr);
						}
					}
				}
				leafs.clear();
				leafs.addAll(next);
			}

			return new ArrayList<>(graph.keySet());
		}
	}

}
