package com.leetcode.problems.breadthfirstsearch.medium;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

}
