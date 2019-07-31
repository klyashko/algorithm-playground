package com.algorithm.playground.leetcode.problems.lc100.lc100.lc103;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
@SuppressWarnings("Duplicates")
public class BinaryTreeZigzagLevelOrderTraversal {

	class Solution {

		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			LinkedList<TreeNode> nodes = new LinkedList<>();
			LinkedList<Integer> levels = new LinkedList<>();
			List<List<Integer>> result = new ArrayList<>();

			nodes.push(root);
			levels.push(0);

			while (!nodes.isEmpty()) {
				TreeNode node = nodes.pop();
				Integer level = levels.pop();
				if (node != null) {
					if (result.size() == level) {
						result.add(new ArrayList<>());
					}
					if ((level & 1) == 0) {
						result.get(level).add(node.val);
					} else {
						result.get(level).add(0, node.val);
					}
					nodes.push(node.right);
					nodes.push(node.left);

					levels.push(level + 1);
					levels.push(level + 1);
				}
			}

			return result;
		}

	}

	class SolutionRecursive {

		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			return traverse(root, 0, new ArrayList<>());
		}

		private List<List<Integer>> traverse(TreeNode node, int level, List<List<Integer>> result) {
			if (node != null) {
				if (result.size() == level) {
					result.add(new ArrayList<>());
				}
				if ((level & 1) == 0) {
					result.get(level).add(node.val);
				} else {
					result.get(level).add(0, node.val);
				}
				traverse(node.left, level + 1, result);
				traverse(node.right, level + 1, result);
			}
			return result;
		}

	}

}
