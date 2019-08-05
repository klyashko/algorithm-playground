package com.algorithm.playground.leetcode.problems.lc100.lc110.lc114;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBinaryTreeToLinkedList {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public void flatten(TreeNode root) {
			List<TreeNode> nodes = flatten(root, new ArrayList<>());
			TreeNode dummy = new TreeNode(0);
			for (TreeNode node : nodes) {
				dummy.left = null;
				dummy.right = node;
				dummy = node;
			}
		}

		private List<TreeNode> flatten(TreeNode root, List<TreeNode> nodes) {
			if (root != null) {
				nodes.add(root);
				flatten(root.left, nodes);
				flatten(root.right, nodes);
			}
			return nodes;
		}

	}

}
