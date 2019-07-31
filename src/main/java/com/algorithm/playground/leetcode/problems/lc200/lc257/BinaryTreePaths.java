package com.algorithm.playground.leetcode.problems.lc200.lc257;

import com.algorithm.playground.leetcode.problems.utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

	class Solution {
		public List<String> binaryTreePaths(TreeNode root) {
			return binaryTreePaths(root, "", new ArrayList<>());
		}

		private List<String> binaryTreePaths(TreeNode root, String curr, List<String> values) {
			if (root != null) {
				curr += root.val;
				if (root.left == null && root.right == null) {
					values.add(curr);
				} else {
					curr = curr + "->";
					binaryTreePaths(root.left, curr, values);
					binaryTreePaths(root.right, curr, values);
				}
			}
			return values;
		}
	}

}
