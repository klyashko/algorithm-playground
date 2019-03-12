package com.algorithm.playground.leetcode.problems.lc300.lc310.lc310;

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
			Map<Integer, Set<Integer>> graph = new HashMap<>();
			for (int[] edge : edges) {
				graph.computeIfAbsent(edge[0], ignored -> new HashSet<>()).add(edge[1]);
				graph.computeIfAbsent(edge[1], ignored -> new HashSet<>()).add(edge[0]);
			}

			Queue<Integer> leafs = new ArrayDeque<>();
			for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
				if (entry.getValue().size() == 1) {
					leafs.offer(entry.getKey());
				}
			}

			while (graph.size() > 2) {
				int size = leafs.size();
				for (int i = 0; i < size; i++) {
					int curr = leafs.poll();
					for (Integer parent : graph.remove(curr)) {
						Set<Integer> children = graph.get(parent);
						children.remove(curr);
						if (children.size() == 1) {
							leafs.offer(parent);
						}
					}
				}
			}

			return new ArrayList<>(graph.keySet());
		}
	}

}
