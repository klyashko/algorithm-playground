package com.algorithm.playground.leetcode.problems.lc0.lc99;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {

	class Solution {

		public void recoverTree(TreeNode root) {
			put(root, collect(root, new TreeSet<>()).iterator());
		}

		private void put(TreeNode node, Iterator<Integer> values) {
			if (node != null) {
				put(node.left, values);
				node.val = values.next();
				put(node.right, values);
			}
		}

		private Set<Integer> collect(TreeNode node, Set<Integer> values) {
			if (node != null) {
				collect(node.left, values);
				values.add(node.val);
				collect(node.right, values);
			}
			return values;
		}

	}

}
