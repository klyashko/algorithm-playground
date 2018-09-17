package com.leetcode.problems.breadthfirstsearch.medium;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

}
