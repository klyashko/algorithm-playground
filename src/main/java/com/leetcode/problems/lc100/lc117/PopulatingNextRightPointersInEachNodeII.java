package com.leetcode.problems.lc100.lc117;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

	class Solution {
		public Node connect(Node root) {
			connect(root, new ArrayList<>(), 0);
			return root;
		}

		private void connect(Node root, List<Node> nodes, int depth) {
			if (root != null) {
				if (depth == nodes.size()) {
					nodes.add(root);
				} else {
					root.next = nodes.get(depth);
					nodes.set(depth, root);
				}
				connect(root.right, nodes, depth + 1);
				connect(root.left, nodes, depth + 1);
			}
		}

	}

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

}
