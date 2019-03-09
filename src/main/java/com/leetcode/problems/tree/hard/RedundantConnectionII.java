package com.leetcode.problems.tree.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/redundant-connection-ii/description/
 */
public class RedundantConnectionII {

	class Solution {
		public int[] findRedundantDirectedConnection(int[][] edges) {
			if (edges.length == 0) {
				return new int[0];
			}
			Map<Integer, List<Integer>> parentToChild = new HashMap<>();
			Map<Integer, List<int[]>> childToParent = new HashMap<>();
			Set<Integer> nodes = new HashSet<>();
			for (int[] edge : edges) {
				parentToChild.computeIfAbsent(edge[0], ignored -> new ArrayList<>()).add(edge[1]);
				childToParent.computeIfAbsent(edge[1], ignored -> new ArrayList<>()).add(edge);
				nodes.add(edge[0]);
				nodes.add(edge[1]);
			}

			for (Integer node : nodes) {
				if (isNotValidate(node, nodes.size(), parentToChild)) {
					continue;
				}
				Set<Integer> visited = new HashSet<>();
				Set<int[]> edgesToDelete = new HashSet<>();
				Queue<Integer> queue = new ArrayDeque<>();
				queue.add(node);
				visited.add(node);

				while (!queue.isEmpty()) {
					Integer current = queue.poll();
					for (int to : parentToChild.getOrDefault(current, Collections.emptyList())) {
						if (visited.contains(to)) {
							edgesToDelete.addAll(childToParent.getOrDefault(to, Collections.emptyList()));
							continue;
						}
						visited.add(to);
						queue.add(to);
					}
				}

				if (!edgesToDelete.isEmpty()) {
					List<int[]> toRemove = new ArrayList<>();
					for (int[] edge : edgesToDelete) {
						parentToChild.get(edge[0]).remove((Integer) edge[1]);
						if (isNotValidate(node, nodes.size(), parentToChild)) {
							toRemove.add(edge);
						}
						parentToChild.get(edge[0]).add(edge[1]);
					}
					edgesToDelete.removeAll(toRemove);

					if (!edgesToDelete.isEmpty()) {
						int[] ans = new int[0];
						for (int[] edge : edges) {
							if (edgesToDelete.contains(edge)) {
								ans = edge;
							}
						}
						return ans;
					}
				}
			}

			return new int[0];
		}


		private boolean isNotValidate(Integer start, int size, Map<Integer, List<Integer>> edges) {
			Set<Integer> visited = new HashSet<>();
			Queue<Integer> q = new ArrayDeque<>();
			q.add(start);
			visited.add(start);
			while (!q.isEmpty()) {
				Integer current = q.poll();
				for (Integer i : edges.getOrDefault(current, Collections.emptyList())) {
					if (!visited.contains(i)) {
						visited.add(i);
						q.add(i);
					}
				}
			}
			return visited.size() != size;
		}

	}

	class SolutionFast {
		public int[] findRedundantDirectedConnection(int[][] edges) {
			Map<Integer, Integer> childrenToParent = new HashMap<>();
			List<int[]> candidates = new ArrayList<>();

			for (int[] edge : edges) {
				if (childrenToParent.containsKey(edge[1])) {
					candidates.add(new int[]{childrenToParent.get(edge[1]), edge[1]});
					candidates.add(edge);
				} else {
					childrenToParent.put(edge[1], edge[0]);
				}
			}
			int root = orbit(1, childrenToParent).node;
			if (candidates.isEmpty()) {
				Set<Integer> cycle = orbit(root, childrenToParent).cycle;
				int[] ans = new int[0];
				for (int[] edge : edges) {
					if (cycle.contains(edge[0]) && cycle.contains(edge[1])) {
						ans = edge;
					}
				}
				return ans;
			}

			Map<Integer, List<Integer>> children = new HashMap<>();
			for (int v : childrenToParent.keySet()) {
				int parent = childrenToParent.get(v);
				children.computeIfAbsent(parent, key -> new ArrayList<>()).add(v);
			}
			boolean[] seen = new boolean[edges.length + 1];
			seen[0] = true;
			LinkedList<Integer> stack = new LinkedList<>();
			stack.push(root);
			while (!stack.isEmpty()) {
				int current = stack.pop();
				if (!seen[current]) {
					seen[current] = true;
					for (int next : children.getOrDefault(current, Collections.emptyList())) {
						stack.push(next);
					}
				}
			}

			for (boolean b : seen) {
				if (!b) {
					return candidates.get(0);
				}
			}

			return candidates.get(1);
		}

		private Result orbit(int node, Map<Integer, Integer> childrenToParent) {
			Set<Integer> seen = new HashSet<>();
			while (childrenToParent.containsKey(node) && seen.add(node)) {
				node = childrenToParent.get(node);
			}
			return new Result(node, seen);
		}

		class Result {
			int node;
			Set<Integer> cycle;

			public Result(int node, Set<Integer> cycle) {
				this.node = node;
				this.cycle = cycle;
			}
		}

	}

}
