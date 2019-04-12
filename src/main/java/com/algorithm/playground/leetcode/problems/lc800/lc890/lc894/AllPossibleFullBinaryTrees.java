package com.algorithm.playground.leetcode.problems.lc800.lc890.lc894;

import com.algorithm.playground.leetcode.problems.utils.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 */
@SuppressWarnings("Duplicates")
public class AllPossibleFullBinaryTrees {

	class Solution {
		public List<TreeNode> allPossibleFBT(int N) {
			if (N == 1) {
				return Collections.singletonList(new TreeNode(0));
			}
			List<TreeNode> list = new ArrayList<>();
			for (int i = 1; i < N - 1; i++) {
				List<TreeNode> left = allPossibleFBT(i);
				List<TreeNode> right = allPossibleFBT(N - i - 1);
				for (TreeNode l : left) {
					for (TreeNode r : right) {
						TreeNode node = new TreeNode(0);
						node.left = l;
						node.right = r;
						list.add(node);
					}
				}
			}
			return list;
		}
	}

	/**
	 * Execution time 87ms
	 */
	class MemoSolution {

		private Map<Integer, List<TreeNode>> cache = new HashMap<>();

		public List<TreeNode> allPossibleFBT(int N) {
			return cache.computeIfAbsent(N, ignored -> {
				if (N == 1) {
					return Collections.singletonList(new TreeNode(0));
				}
				List<TreeNode> list = new ArrayList<>();
				for (int i = 1; i < N - 1; i++) {
					List<TreeNode> left = allPossibleFBT(i);
					List<TreeNode> right = allPossibleFBT(N - i - 1);
					for (TreeNode l : left) {
						for (TreeNode r : right) {
							TreeNode node = new TreeNode(0);
							node.left = l;
							node.right = r;
							list.add(node);
						}
					}
				}
				return list;
			});
		}
	}

	/**
	 * Execution time 7ms
	 */
	class MemoSolution_ {

		private Map<Integer, List<TreeNode>> cache = new HashMap<>();

		public List<TreeNode> allPossibleFBT(int N) {
			if (!cache.containsKey(N)) {
				List<TreeNode> list = new ArrayList<>();
				if (N == 1) {
					list.add(new TreeNode(0));
				}
				for (int i = 1; i < N - 1; i++) {
					List<TreeNode> left = allPossibleFBT(i);
					List<TreeNode> right = allPossibleFBT(N - i - 1);
					for (TreeNode l : left) {
						for (TreeNode r : right) {
							TreeNode node = new TreeNode(0);
							node.left = l;
							node.right = r;
							list.add(node);
						}
					}
				}
				cache.put(N, list);
			}
			return cache.get(N);
		}
	}

}
