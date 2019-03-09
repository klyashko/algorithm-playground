package com.algorithm.playground.leetcode.problems.tree.easy;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/description/
 */
public class LeafSimilarTrees {

	class Solution {

		public boolean leafSimilar(TreeNode root1, TreeNode root2) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			traverse(root1, list1);
			traverse(root2, list2);
			return list1.equals(list2);
		}

		private void traverse(TreeNode node, List<Integer> list) {
			if (node == null) {
				return;
			}
			if (node.left == null && node.right == null) {
				list.add(node.val);
				return;
			}
			traverse(node.left, list);
			traverse(node.right, list);
		}

	}

}
