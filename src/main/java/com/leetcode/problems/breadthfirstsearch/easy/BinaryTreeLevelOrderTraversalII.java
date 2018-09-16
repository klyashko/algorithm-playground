package com.leetcode.problems.breadthfirstsearch.easy;

import com.leetcode.problems.tree.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 */
public class BinaryTreeLevelOrderTraversalII {

	class Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			List<List<Integer>> values = new ArrayList<>();
			levelOrderBottom(root, values, 0);
			return values;
		}

		private void levelOrderBottom(TreeNode node, List<List<Integer>> values, int depth) {
			if (node == null) {
				return;
			}
			if (depth >= values.size()) {
				values.add(0, new ArrayList<>());
			}
			levelOrderBottom(node.left, values, depth + 1);
			levelOrderBottom(node.right, values, depth + 1);
			values.get(values.size() - depth - 1).add(node.val);
		}
	}

	class IterativeSolution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			Queue<TreeNode> queue = new ArrayDeque<>();
			queue.add(root);
			List<List<Integer>> result = new ArrayList<>();

			while (!queue.isEmpty()) {
				int size = queue.size();
				result.add(0, new ArrayList<>());
				while (size > 0) {
					TreeNode n = queue.poll();
					size--;
					//noinspection ConstantConditions
					result.get(0).add(n.val);
					if (n.left != null) {
						queue.add(n.left);
					}
					if (n.right != null) {
						queue.add(n.right);
					}
				}
			}

			return result;
		}
	}

}
