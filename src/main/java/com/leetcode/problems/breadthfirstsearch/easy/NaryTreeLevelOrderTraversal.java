package com.leetcode.problems.breadthfirstsearch.easy;

import com.leetcode.problems.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 */
public class NaryTreeLevelOrderTraversal {

	class Solution {
		public List<List<Integer>> levelOrder(Node root) {
			List<List<Integer>> values = new ArrayList<>();
			levelOrder(root, values, 0);
			return values;
		}

		private void levelOrder(Node node, List<List<Integer>> values, int depth) {
			if (node == null) {
				return;
			}
			if (values.size() <= depth) {
				values.add(new ArrayList<>());
			}
			values.get(depth).add(node.val);
			if (node.children != null) {
				for (Node next : node.children) {
					levelOrder(next, values, depth + 1);
				}
			}
		}
	}

}
