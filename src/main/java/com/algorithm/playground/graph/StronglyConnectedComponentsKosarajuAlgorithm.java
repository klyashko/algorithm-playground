package com.algorithm.playground.graph;

import java.util.*;
import java.util.Map.Entry;

import static com.algorithm.playground.utils.FunctionUtils.newArrayList;
import static java.util.Collections.emptyList;

/**
 * An implementation for Kosaraju's Algorithm for finding strongly connected components
 * based on an idea from this video:
 * https://www.youtube.com/watch?v=RpgcYiky7uw&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j&index=9
 *
 * @param <V>
 */
public class StronglyConnectedComponentsKosarajuAlgorithm<V> {

	public List<Set<V>> getComponents(Map<V, List<V>> graph) {
		LinkedList<V> stack = new LinkedList<>();

		Set<V> seen = new HashSet<>();
		for (V curr : graph.keySet()) {
			firstDFS(graph, seen, stack, curr);
		}

		Map<V, List<V>> reversed = reverse(graph);

		List<Set<V>> components = new ArrayList<>();
		LinkedList<V> dfs = new LinkedList<>();
		seen.clear();

		/** second dfs */
		while (!stack.isEmpty()) {
			V curr = stack.pop();
			if (!seen.contains(curr)) {
				dfs.push(curr);
				Set<V> set = new HashSet<>();
				while (!dfs.isEmpty()) {
					V next = dfs.pop();
					if (seen.add(next)) {
						set.add(next);
						for (V child : reversed.getOrDefault(next, emptyList())) {
							dfs.push(child);
						}
					}
				}
				components.add(set);
			}

		}
		return components;
	}

	private void firstDFS(Map<V, List<V>> graph, Set<V> seen, LinkedList<V> stack, V curr) {
		if (!seen.add(curr)) {
			return;
		}
		for (V next : graph.getOrDefault(curr, emptyList())) {
			if (!seen.contains(next)) {
				firstDFS(graph, seen, stack, next);
			}
		}
		stack.push(curr);
	}

	private Map<V, List<V>> reverse(Map<V, List<V>> graph) {
		Map<V, List<V>> reversed = new HashMap<>();
		for (Entry<V, List<V>> entry : graph.entrySet()) {
			for (V child : entry.getValue()) {
				reversed.computeIfAbsent(child, newArrayList()).add(entry.getKey());
			}
		}
		return reversed;
	}

}
