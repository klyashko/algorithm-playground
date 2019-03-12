package com.algorithm.playground.leetcode.problems.lc0.lc99;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySearchTree {

	class Solution {
		public void recoverTree(TreeNode root) {
			List<Integer> values = new ArrayList<>();
			collect(root, values);
			values.sort(Integer::compareTo);
			put(root, values, new int[]{0});
		}

		private void put(TreeNode node, List<Integer> list, int[] idx) {
			if (node != null) {
				put(node.left, list, idx);
				node.val = list.get(idx[0]);
				idx[0]++;
				put(node.right, list, idx);
			}
		}

		private void collect(TreeNode node, List<Integer> list) {
			if (node != null) {
				collect(node.left, list);
				list.add(node.val);
				collect(node.right, list);
			}
		}

	}

}
