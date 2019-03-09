package com.algorithm.playground.leetcode.problems.lc100.lc130.lc133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

	class Solution {
		public Node cloneGraph(Node node) {
			return cloneNode(node, new HashMap<>());
		}

		private Node cloneNode(Node node, Map<Node, Node> cache) {
			if (!cache.containsKey(node)) {
				Node curr = new Node();
				curr.val = node.val;
				curr.neighbors = new ArrayList<>();

				cache.put(node, curr);

				for (Node next : node.neighbors) {
					curr.neighbors.add(cloneNode(next, cache));
				}
			}
			return cache.get(node);
		}
	}

}
