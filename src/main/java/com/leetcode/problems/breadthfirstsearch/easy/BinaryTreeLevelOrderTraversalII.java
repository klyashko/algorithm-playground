package com.leetcode.problems.breadthfirstsearch.easy;

import com.leetcode.problems.tree.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 */
public class BinaryTreeLevelOrderTraversalII {

	class Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			return null;
		}

		public void levelOrderBottom(TreeNode node, List<List<Integer>> values) {
			if (node == null) {
				return;
			}

		}
	}

	class IterativeSolution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			if (root == null) {
				return Collections.emptyList();
			}
			Queue<TreeNode> queue = new ArrayDeque<>();
			LinkedList<TreeNode> stack = new LinkedList<>();
			LinkedList<Integer> sizes = new LinkedList<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				sizes.push(size);
				while (size > 0) {
					TreeNode n = queue.poll();
					size--;
					stack.push(n);
					//noinspection ConstantConditions
					if (n.right != null) {
						queue.add(n.right);
					}
					if (n.left != null) {
						queue.add(n.left);
					}
				}
			}

			List<List<Integer>> result = new ArrayList<>();

			while (!stack.isEmpty()) {
				int size = sizes.pop();
				result.add(new ArrayList<>());
				while (size > 0) {
					TreeNode n = stack.pop();
					size--;
					result.get(result.size() - 1).add(n.val);
				}
			}

			return result;
		}
	}

}
