package com.algorithm.playground.leetcode.problems.lc100.lc140.lc145;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 */
public class BinaryTreePostorderTraversal {

	class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			LinkedList<TreeNode> stack = new LinkedList<>();
			List<Integer> values = new ArrayList<>();
			stack.push(root);

			while (!stack.isEmpty()) {
				TreeNode n = stack.poll();
				if (n == null) {
					continue;
				}
				values.add(0, n.val);
				stack.push(n.left);
				stack.push(n.right);
			}

			return values;
		}
	}

}
