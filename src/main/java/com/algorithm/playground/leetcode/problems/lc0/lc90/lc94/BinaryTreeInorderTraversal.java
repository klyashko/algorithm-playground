package com.algorithm.playground.leetcode.problems.lc0.lc90.lc94;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

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

			TreeNode curr = root;
			while (curr != null || !stack.isEmpty()) {
				while (curr != null) {
					stack.push(curr);
					curr = curr.left;
				}
				curr = stack.pop();
				values.add(curr.val);
				curr = curr.right;
			}

			return values;
		}
	}

	class MSolution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> values = new ArrayList<>();
			TreeNode curr = root;

			while (curr != null) {
				TreeNode successor = find(curr.left, curr);
				if (successor == null || successor.right == curr) {
					values.add(curr.val);
					if (successor != null) {
						successor.right = null;
					}
					curr = curr.right;
				} else {
					successor.right = curr;
					curr = curr.left;
				}
			}

			return values;
		}

		private TreeNode find(TreeNode curr, TreeNode node) {
			if (curr == null) {
				return null;
			} else {
				while (curr.right != null && curr.right != node) {
					curr = curr.right;
				}
				return curr;
			}
		}

	}

}
