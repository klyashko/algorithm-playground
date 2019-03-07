package com.leetcode.problems.lc100.lc117;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

	class Solution {
		public Node connect(Node root) {
			return connect(root, new ArrayList<>(), 0);
		}

		private Node connect(Node root, List<Node> nodes, int depth) {
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
			return root;
		}

	}

}
