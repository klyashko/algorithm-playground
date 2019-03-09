package com.algorithm.playground.leetcode.problems.design.medium;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 */
public class BinarySearchTreeIterator {

	public static BSTIterator bstIterator(TreeNode node) {
		return new BinarySearchTreeIterator().createBSTIterator(node);
	}

	private BSTIterator createBSTIterator(TreeNode node) {
		return new BSTIterator(node);
	}

	public class BSTIterator {

		private LinkedList<TreeNode> stack = new LinkedList<>();
		private TreeNode curr;

		public BSTIterator(TreeNode root) {
			curr = root;
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return curr != null || !stack.isEmpty();
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			int val = curr.val;
			curr = curr.right;
			return val;
		}
	}

}
