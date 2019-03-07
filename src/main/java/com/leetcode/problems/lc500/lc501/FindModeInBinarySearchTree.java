package com.leetcode.problems.lc500.lc501;

import com.leetcode.problems.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class FindModeInBinarySearchTree {

	class Solution {

		public int[] findMode(TreeNode root) {
			Map<Integer, Integer> counts = findMode(root, new HashMap<>());
			int max = Integer.MIN_VALUE, size = 0;
			for (Integer i : counts.values()) {
				if (i > max) {
					max = i;
					size = 1;
				} else if (i == max) {
					size++;
				}
			}
			int[] ans = new int[size];
			int idx = 0;
			for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
				if (entry.getValue().equals(max)) {
					ans[idx++] = entry.getKey();
				}
			}
			return ans;
		}

		private Map<Integer, Integer> findMode(TreeNode root, Map<Integer, Integer> counts) {
			if (root == null) {
				return counts;
			}
			counts.put(root.val, counts.getOrDefault(root.val, 0) + 1);
			findMode(root.left, counts);
			return findMode(root.right, counts);
		}
	}

}
