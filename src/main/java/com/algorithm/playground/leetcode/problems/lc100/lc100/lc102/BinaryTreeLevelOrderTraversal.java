package com.algorithm.playground.leetcode.problems.lc100.lc100.lc102;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeLevelOrderTraversal {

	class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> values = new ArrayList<>();
			levelOrder(root, values, 0);
			return values;
		}

		private void levelOrder(TreeNode n, List<List<Integer>> values, int level) {
			if (n == null) {
				return;
			}
			if (values.size() == level) {
				values.add(new ArrayList<>());
			}
			values.get(level).add(n.val);
			levelOrder(n.left, values, level + 1);
			levelOrder(n.right, values, level + 1);
		}
	}

	class IterativeSolution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> values = new ArrayList<>();
			if (root == null) {
				return values;
			}
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				values.add(new ArrayList<>());
				while (size > 0) {
					TreeNode n = queue.poll();
					size--;
					if (n == null) {
						continue;
					}
					values.get(values.size() - 1).add(n.val);
					queue.add(n.left);
					queue.add(n.right);
				}
			}
			values.remove(values.size() - 1);
			return values;
		}
	}

}
