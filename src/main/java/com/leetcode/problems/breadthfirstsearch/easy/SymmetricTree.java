package com.leetcode.problems.breadthfirstsearch.easy;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class SymmetricTree {

	class Solution {
		public boolean isSymmetric(TreeNode root) {
			return root == null || isSymmetric(root.left, root.right);
		}

		private boolean isSymmetric(TreeNode n1, TreeNode n2) {
			if (n1 == null && n2 == null) {
				return true;
			} else if (n1 == null || n2 == null || n1.val != n2.val) {
				return false;
			}
			return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
		}
	}

	class IterativeSolution {
		public boolean isSymmetric(TreeNode root) {
			if (root == null || (root.left == null && root.right == null)) {
				return true;
			}
			if (root.left == null || root.right == null) {
				return false;
			}
			Queue<TreeNode> left = new ArrayDeque<>();
			Queue<TreeNode> right = new ArrayDeque<>();
			left.add(root.left);
			right.add(root.right);
			while (!left.isEmpty()) {
				TreeNode l = left.poll();
				TreeNode r = right.poll();
				//noinspection ConstantConditions
				if (l.val != r.val) {
					return false;
				}
				if (l.left != null && r.right != null) {
					left.add(l.left);
					right.add(r.right);
				} else if (l.left == null && r.right != null || l.left != null) {
					return false;
				}
				if (l.right != null && r.left != null) {
					left.add(l.right);
					right.add(r.left);
				} else if (l.right == null && r.left != null || l.right != null) {
					return false;
				}
			}
			return true;
		}
	}

}
