package com.leetcode.problems.lc310;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
@SuppressWarnings("ConstantConditions")
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

			Queue<Integer> leafs = new ArrayDeque<>();
			for (int i = 0; i < degrees.length; i++) {
				if (degrees[i] == 1) {
					leafs.offer(i);
				}
			}

			while (graph.size() > 2) {
				int size = leafs.size();
				for (int i = 0; i < size; i++) {
					int curr = leafs.poll();
					degrees[curr] = 0;
					for (Integer parent : graph.remove(curr)) {
						degrees[parent]--;
						if (degrees[parent] == 1) {
							leafs.offer(parent);
						}
						graph.get(parent).remove(curr);
					}
				}
			}

			return new ArrayList<>(graph.keySet());
		}
	}

}
