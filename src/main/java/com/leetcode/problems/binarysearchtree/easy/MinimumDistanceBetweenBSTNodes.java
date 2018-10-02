package com.leetcode.problems.binarysearchtree.easy;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 */
public class MinimumDistanceBetweenBSTNodes {

	class Solution {
		public int minDiffInBST(TreeNode root) {
			List<Integer> list = new ArrayList<>();
			traverse(root, list);
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < list.size(); i++) {
				min = Math.min(min, list.get(i) - list.get(i - 1));
			}
			return min;
		}

		private void traverse(TreeNode node, List<Integer> values) {
			if (node == null) {
				return;
			}
			traverse(node.left, values);
			values.add(node.val);
			traverse(node.right, values);
		}
	}

}
