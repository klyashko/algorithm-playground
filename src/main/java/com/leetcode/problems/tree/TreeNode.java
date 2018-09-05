package com.leetcode.problems.tree;

import java.util.List;
import java.util.Objects;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {

	}

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

	public static TreeNode valueOf(List<Integer> values) {
		return valueOf(values.toArray(new Integer[0]));
	}

	public static TreeNode valueOf(Integer[] values) {
		if (values.length == 0) {
			return null;
		}
		return valueOf(values, 1);
	}

	public static Integer[] toArray(TreeNode node) {
		Integer[] array = new Integer[size(node) + 10];
		packNode(node, 1, array);
		return array;
	}

	private static void packNode(TreeNode n, int idx, Integer[] array) {
		if (n == null) {
			return;
		}
		array[idx - 1] = n.val;
		packNode(n.left, idx * 2, array);
		packNode(n.right, idx * 2 + 1, array);
	}

	private static int size(TreeNode n) {
		if (n == null) {
			return 0;
		}
		return 1 + size(n.left) + size(n.right);
	}

	private static TreeNode valueOf(Integer[] values, int idx) {
		if (idx > values.length || values[idx - 1] == null) {
			return null;
		}
		TreeNode node = new TreeNode(values[idx - 1]);
		node.left = valueOf(values, idx * 2);
		node.right = valueOf(values, idx * 2 + 1);
		return node;
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
}
