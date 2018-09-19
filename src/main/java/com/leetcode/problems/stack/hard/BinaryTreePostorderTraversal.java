package com.leetcode.problems.stack.hard;

import com.leetcode.problems.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 */
public class BinaryTreePostorderTraversal {

	class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			LinkedList<TreeNode> stack = new LinkedList<>();
			Queue<TreeNode> left = new LinkedList<>();
			Queue<TreeNode> right = new LinkedList<>();

			left.offer(root);

			while (!left.isEmpty()) {
				TreeNode n = left.poll();
				if (n != null) {
					stack.push(n);
					left.add(n.left);
					right.add(n.right);
				}
				if (left.isEmpty() && !right.isEmpty()) {
					TreeNode next = right.poll();
					while (next == null && !right.isEmpty()) {
						next = right.poll();
					}
					if (next != null) {
						stack.push(next);
						left.add(next.left);
						right.add(next.right);
					}
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
