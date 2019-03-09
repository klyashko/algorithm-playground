package com.algorithm.playground.leetcode.problems.breadthfirstsearch.easy;

import com.algorithm.playground.leetcode.problems.tree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

	class IterativeSolution {
		public List<List<Integer>> levelOrder(Node root) {
			List<List<Integer>> values = new ArrayList<>();
			if (root != null) {
				Queue<Node> queue = new ArrayDeque<>();
				queue.add(root);
				int size = queue.size();
				while (!queue.isEmpty()) {
					values.add(new ArrayList<>());
					while (size > 0) {
						Node n = queue.poll();
						size--;
						//noinspection ConstantConditions
						values.get(values.size() - 1).add(n.val);
						if (n.children != null) {
							queue.addAll(n.children);
						}
					}
					size = queue.size();
				}
			}
			return values;
		}
	}

}
