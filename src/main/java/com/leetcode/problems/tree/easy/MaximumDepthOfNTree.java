package com.leetcode.problems.tree.easy;

import com.leetcode.problems.tree.Node;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
 */
public class MaximumDepthOfNTree {

	class Solution {
		public int maxDepth(Node root) {
			if (root == null) {
				return 0;
			}
			return dfs(root, 1);
		}

		private int dfs(Node n, int size) {
			if (n.children == null) {
				return size;
			}

			int max = size;
			for (Node child : n.children) {
				max = Math.max(max, dfs(child, size + 1));
			}
			return max;
		}
	}

}
