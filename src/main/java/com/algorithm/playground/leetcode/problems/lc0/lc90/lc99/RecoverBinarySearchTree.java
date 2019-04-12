package com.algorithm.playground.leetcode.problems.lc0.lc90.lc99;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {

	class Solution {

		public void recoverTree(TreeNode root) {
			put(root, collect(root, new PriorityQueue<>()));
		}

		private void put(TreeNode node, PriorityQueue<Integer> values) {
			if (node != null) {
				put(node.left, values);
				//noinspection ConstantConditions
				node.val = values.poll();
				put(node.right, values);
			}
		}

		private PriorityQueue<Integer> collect(TreeNode node, PriorityQueue<Integer> values) {
			if (node != null) {
				collect(node.left, values);
				values.add(node.val);
				collect(node.right, values);
			}
			return values;
		}

	}

}
