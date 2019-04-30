package com.algorithm.playground.leetcode.problems.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {

	private static final String NULL = "null";
	private static final String DELIMITER = ",";

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() { }

	public TreeNode(int x) { val = x; }

	public void setVal(int val) {
		this.val = val;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public static TreeNode node(List<Integer> values) {
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> nodeQueue = new LinkedList<>();

		for (Integer i : values) {
			queue.offer(i != null ? new TreeNode(i) : null);
		}

		TreeNode root = queue.poll();
		nodeQueue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode curr = nodeQueue.poll();
			if (curr == null) {
				continue;
			}
			curr.left = queue.poll();
			curr.right = queue.poll();

			nodeQueue.offer(curr.left);
			nodeQueue.offer(curr.right);
		}

		return root;
	}

	public static String toString(TreeNode root) {
		StringBuilder builder = new StringBuilder();
		toStringBuilder(root, builder);
		return builder.deleteCharAt(builder.length() - 1).toString();
	}

	private static void toStringBuilder(TreeNode node, StringBuilder builder) {
		if (node == null) {
			builder.append(NULL).append(DELIMITER);
			return;
		}
		builder.append(node.val).append(DELIMITER);
		toStringBuilder(node.left, builder);
		toStringBuilder(node.right, builder);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TreeNode treeNode = (TreeNode) o;
		return val == treeNode.val &&
				Objects.equals(left, treeNode.left) &&
				Objects.equals(right, treeNode.right);
	}

	@Override
	public int hashCode() {
		return Objects.hash(val, left, right);
	}

	@Override
	public String toString() {
		return "TreeNode{" + toString(this) + "}";
	}
}
