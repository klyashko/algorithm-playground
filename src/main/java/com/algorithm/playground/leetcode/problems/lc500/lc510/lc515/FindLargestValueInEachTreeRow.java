package com.algorithm.playground.leetcode.problems.lc500.lc510.lc515;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 */
public class FindLargestValueInEachTreeRow {

	class Solution {
		public List<Integer> largestValues(TreeNode root) {
			List<Integer> values = new ArrayList<>();
			dfs(root, values, 0);
			return values;
		}

		private void dfs(TreeNode n, List<Integer> values, int depth) {
			if (n == null) {
				return;
			}
			if (values.size() == depth) {
				values.add(n.val);
			} else {
				if (values.get(depth) < n.val) {
					values.set(depth, n.val);
				}
			}
			dfs(n.left, values, depth + 1);
			dfs(n.right, values, depth + 1);
		}
	}

}
