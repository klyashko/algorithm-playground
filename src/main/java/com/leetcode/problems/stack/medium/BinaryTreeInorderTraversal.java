package com.leetcode.problems.stack.medium;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
public class BinaryTreeInorderTraversal {

	class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> values = new ArrayList<>();
			LinkedList<TreeNode> stack = new LinkedList<>();

			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			while (!stack.isEmpty()) {
				TreeNode n = stack.poll();
				//noinspection ConstantConditions
				values.add(n.val);

				n = n.right;
				while (n != null) {
					stack.push(n);
					n = n.left;
				}
			}

			return values;
		}
	}

}
