package com.algorithm.playground.leetcode.problems.lc300.lc330.lc332;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {

	class Solution {
		public List<String> findItinerary(List<List<String>> tickets) {
			String start = "JFK";
			Map<String, List<Edge>> edges = new HashMap<>();
			for (List<String> e : tickets) {
				if (!edges.containsKey(e.get(0))) {
					edges.put(e.get(0), new ArrayList<>());
				}
				edges.get(e.get(0)).add(new Edge(e.get(0), e.get(1)));
			}
			for (List<Edge> list : edges.values()) {
				list.sort(Edge::compareTo);
			}
			List<String> itinerary = new ArrayList<>();
			dfs(edges, start, new HashSet<>(), itinerary, tickets.size() + 1);
			return itinerary;
		}

		private boolean dfs(Map<String, List<Edge>> edges, String curr, Set<Edge> seen, List<String> itinerary, int n) {
			itinerary.add(curr);
			if (itinerary.size() == n) {
				return true;
			} else if (edges.containsKey(curr)) {
				for (Edge e : edges.getOrDefault(curr, Collections.emptyList())) {
					if (seen.add(e)) {
						if (dfs(edges, e.to, seen, itinerary, n)) {
							return true;
						} else {
							seen.remove(e);
						}
					}
				}
			}
			itinerary.remove(itinerary.size() - 1);
			return false;
		}

		private class Edge implements Comparable<Edge> {

			private final String from, to;

			private Edge(String from, String to) {
				this.from = from;
				this.to = to;
			}

			@Override
			public int compareTo(Edge o) {
				return to.compareTo(o.to);
			}

			@Override
			public String toString() {
				return "Edge{" +
						"from='" + from + '\'' +
						", to='" + to + '\'' +
						'}';
			}
		}

	}

}
