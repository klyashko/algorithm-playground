package com.leetcode.problems.tree.medium;

import com.leetcode.problems.tree.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class AllNodesDistanceKInBinaryTree {

	class Solution {
		public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
			if (root == null) {
				return Collections.emptyList();
			}
			Map<Integer, TreeNode> parents = new HashMap<>();
			dfs(parents, root);

			Set<Integer> seen = new HashSet<>();
			Queue<TreeNode> queue = new ArrayDeque<>();

			TreeNode tmp = parents.get(target.val);
			TreeNode start = tmp == null ? root : (tmp.left != null && tmp.left.val == target.val) ? tmp.left : tmp.right;

			queue.add(start);
			seen.add(start.val);

			for (; K > 0 && !queue.isEmpty(); K--) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					if (node == null) {
						continue;
					}
					if (node.left != null && seen.add(node.left.val)) {
						queue.add(node.left);
					}
					if (node.right != null && seen.add(node.right.val)) {
						queue.add(node.right);
					}
					TreeNode parent = parents.get(node.val);
					if (parent != null && seen.add(parent.val)) {
						queue.add(parent);
					}
				}
			}
			List<Integer> list = new ArrayList<>();
			while (!queue.isEmpty()) {
				list.add(queue.poll().val);
			}
			return list;
		}

		private void dfs(Map<Integer, TreeNode> parents, TreeNode root) {
			if (root.left != null) {
				parents.put(root.left.val, root);
				dfs(parents, root.left);
			}
			if (root.right != null) {
				parents.put(root.right.val, root);
				dfs(parents, root.right);
			}
		}
	}

}
