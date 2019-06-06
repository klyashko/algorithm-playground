package com.algorithm.playground.leetcode.problems.lc300.lc330.lc332;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {

	class Solution {
		public List<String> findItinerary(List<List<String>> tickets) {
			Map<String, Queue<String>> edges = new HashMap<>();
			for (List<String> e : tickets) {
				if (!edges.containsKey(e.get(0))) {
					edges.put(e.get(0), new PriorityQueue<>());
				}
				edges.get(e.get(0)).offer(e.get(1));
			}
			return dfs(edges, "JFK", new ArrayList<>());
		}

		private List<String> dfs(Map<String, Queue<String>> edges, String curr, List<String> itinerary) {
			Queue<String> queue = edges.get(curr);
			while (queue != null && !queue.isEmpty()) {
				dfs(edges, queue.poll(), itinerary);
			}
			itinerary.add(0, curr);
			return itinerary;
		}

	}

}
