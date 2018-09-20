package com.leetcode.problems.design.medium;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

		int idx;
		private List<Integer> values = new ArrayList<>();

		public BSTIterator(TreeNode root) {
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
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return idx < values.size();
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
			return values.get(idx++);
		}
	}

}
