package com.leetcode.problems.stack.hard;

import com.leetcode.problems.tree.TreeNode;

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
			LinkedList<TreeNode> leftStack = new LinkedList<>();

			TreeNode curr = root;

			while (curr != null || !leftStack.isEmpty()) {
				while (curr != null) {
					stack.push(curr);
					leftStack.push(curr);
					curr = curr.right;
				}
				while (curr == null && !leftStack.isEmpty()) {
					curr = leftStack.pop().left;
				}
			}

			List<Integer> values = new ArrayList<>();
			while (!stack.isEmpty()) {
				//noinspection ConstantConditions
				values.add(stack.poll().val);
			}

			return values;
		}
	}

}
