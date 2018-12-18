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

	class DFSOnlySolution {
		public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
			List<Integer> vals = new ArrayList<>();
			dfs(root, target.val, K, -1, vals);
			return vals;
		}

		private int dfs(TreeNode node, int val, int K, int dist, List<Integer> values) {
			if (node == null) {
				return -1;
			}
			int top = -1;
			if (node.val == val) {
				dist = K;
				top = 1;
			}
			if (dist >= 0) {
				if (dist == 0) {
					values.add(node.val);
					return -1;
				} else {
					dfs(node.left, val, K, dist - 1, values);
					dfs(node.right, val, K, dist - 1, values);
					return top;
				}
			}
			int L = dfs(node.left, val, K, dist, values);
			if (L == K) {
				values.add(node.val);
				return -1;
			} else if (L >= 0 && L < K) {
				dfs(node.right, val, K, K - L - 1, values);
			}

			int R = dfs(node.right, val, K, dist, values);
			if (R == K) {
				values.add(node.val);
				return -1;
			} else if (R >= 0 && R < K) {
				dfs(node.left, val, K, K - R - 1, values);
			}
			int max = Math.max(L, R);
			if (max == -1) {
				return -1;
			}
			return max + 1;
		}
	}

}
