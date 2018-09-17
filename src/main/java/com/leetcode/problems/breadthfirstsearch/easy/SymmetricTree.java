package com.leetcode.problems.breadthfirstsearch.easy;

import com.leetcode.problems.tree.TreeNode;

import java.util.LinkedList;
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
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root.left);
			queue.add(root.right);
			while (!queue.isEmpty()) {
				TreeNode l = queue.poll();
				TreeNode r = queue.poll();
				if (l == null && r == null) {
					continue;
				} else if (l == null || r == null || l.val != r.val) {
					return false;
				}
				queue.add(l.left);
				queue.add(r.right);

				queue.add(l.right);
				queue.add(r.left);
			}
			return true;
		}
	}

}
