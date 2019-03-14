package com.algorithm.playground.leetcode.problems.lc200.lc257;

import com.algorithm.playground.leetcode.problems.tree.TreeNode;

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
			if (root != null && root.left == null && root.right == null) {
				if (curr.isEmpty()) {
					values.add(curr + root.val);
				} else {
					values.add(curr.substring(2) + "->" + root.val);
				}
			} else if (root != null) {
				curr = curr + "->" + root.val;
				binaryTreePaths(root.left, curr, values);
				binaryTreePaths(root.right, curr, values);
			}
			return values;
		}
	}

}
