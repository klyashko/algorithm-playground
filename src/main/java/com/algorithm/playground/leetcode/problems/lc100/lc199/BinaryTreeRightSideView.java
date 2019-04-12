package com.algorithm.playground.leetcode.problems.lc100.lc199;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class BinaryTreeRightSideView {

	class Solution {
		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> values = new ArrayList<>();
			bfs(root, values, 0);
			return values;
		}

		private void bfs(TreeNode node, List<Integer> values, int level) {
			if (node == null) {
				return;
			}
			if (values.size() > level) {
				values.set(level, node.val);
			} else {
				values.add(node.val);
			}
			bfs(node.left, values, level + 1);
			bfs(node.right, values, level + 1);
		}
	}

	class IterativeSolution {
		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> values = new ArrayList<>();
			if (root == null) {
				return values;
			}

			Queue<TreeNode> queue = new ArrayDeque<>();
			queue.add(root);

			while (!queue.isEmpty()) {
				int size = queue.size();
				while (size > 0) {
					TreeNode n = queue.poll();
					if (--size == 0) {
						//noinspection ConstantConditions
						values.add(n.val);
					}
					//noinspection ConstantConditions
					if (n.left != null) {
						queue.add(n.left);
					}
					if (n.right != null) {
						queue.add(n.right);
					}
				}
			}

			return values;
		}
	}

}
