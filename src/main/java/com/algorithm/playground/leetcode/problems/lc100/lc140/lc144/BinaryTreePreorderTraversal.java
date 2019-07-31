package com.algorithm.playground.leetcode.problems.lc100.lc140.lc144;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class BinaryTreePreorderTraversal {

	class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> values = new ArrayList<>();
			LinkedList<TreeNode> stack = new LinkedList<>();
			stack.push(root);

			while (!stack.isEmpty()) {
				TreeNode n = stack.poll();
				if (n == null) {
					continue;
				}
				values.add(n.val);
				stack.push(n.right);
				stack.push(n.left);
			}

			return values;
		}
	}

}
