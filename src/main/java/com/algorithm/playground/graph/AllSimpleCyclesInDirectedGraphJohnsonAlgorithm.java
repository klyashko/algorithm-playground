package com.algorithm.playground.graph;

import java.util.*;

import static java.util.Collections.emptyList;

public class AllSimpleCyclesInDirectedGraphJohnsonAlgorithm<V> {

	public List<List<V>> getCycles(Map<V, List<V>> graph) {
		List<List<V>> cycles = new ArrayList<>();
		StronglyConnectedComponentsKosarajuAlgorithm<V> scc = new StronglyConnectedComponentsKosarajuAlgorithm<>();

		LinkedList<V> stack = new LinkedList<>();
		Set<V> blockingSet = new HashSet<>();
		Map<V, V> blockingMap = new HashMap<>();

		while (!graph.isEmpty()) {
			List<Set<V>> components = scc.getComponents(graph);
			int size = cycles.size();

			for (int i = 0; i < components.size() && size == cycles.size(); i++) {
				for (V curr : components.get(i)) {
					if (getCycles(curr, curr, curr, cycles, stack, blockingSet, blockingMap, graph)) {
						remove(curr, graph);
						break;
					}
				}
			}

			if (size == cycles.size()) {
				break;
			}
		}
		return cycles;
	}

	private boolean getCycles(V source, V curr, V from, List<List<V>> cycles, LinkedList<V> stack, Set<V> blockingSet, Map<V, V> blockingMap, Map<V, List<V>> graph) {
		if (source.equals(curr) && !blockingSet.isEmpty()) {
			cycles.add(new ArrayList<>(stack));
			return true;
		} else if (blockingSet.add(curr)) {
			boolean toReturn = false;
			for (V next : graph.getOrDefault(curr, emptyList())) {
				stack.push(next);
				if (getCycles(source, next, curr, cycles, stack, blockingSet, blockingMap, graph)) {
					unblock(next, blockingSet, blockingMap);
					toReturn = true;
				}
				stack.pop();
			}
			return toReturn;
		} else {
			blockingMap.put(curr, from);
			return false;
		}
	}

	private void unblock(V curr, Set<V> blockingSet, Map<V, V> blockingMap) {
		if (curr != null) {
			blockingSet.remove(curr);
			curr = blockingMap.remove(curr);
			unblock(curr, blockingSet, blockingMap);
		}
	}

	private void remove(V curr, Map<V, List<V>> graph) {
		graph.remove(curr);
		graph.values().forEach(l -> l.remove(curr));
	}

}
