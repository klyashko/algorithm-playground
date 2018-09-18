package com.leetcode.problems.stack.medium;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
public class BinaryTreeInorderTraversal {

	class Solution {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> values = new ArrayList<>();
			LinkedList<TreeNode> stack = new LinkedList<>();

			TreeNode curr = root;
			while (curr != null || !stack.isEmpty()) {
				while (curr != null) {
					stack.push(curr);
					curr = curr.left;
				}
				curr = stack.pop();
				values.add(curr.val);
				curr = curr.right;
			}

			return values;
		}
	}

}
