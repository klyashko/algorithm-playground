package com.leetcode.problems.binarysearch.medium;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementInABST {

	class Solution {
		public int kthSmallest(TreeNode root, int k) {
			List<Integer> list = toList(root);
			list.sort(Integer::compareTo);
			return list.get(k - 1);
		}

		private List<Integer> toList(TreeNode root) {
			List<Integer> list = new ArrayList<>();
			toList(root, list);
			return list;
		}

		private void toList(TreeNode node, List<Integer> list) {
			if (node == null) {
				return;
			}
			list.add(node.val);
			toList(node.left, list);
			toList(node.right, list);
		}
	}

}
