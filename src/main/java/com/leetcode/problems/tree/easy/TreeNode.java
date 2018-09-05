package com.leetcode.problems.tree.easy;

import java.util.Objects;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {

	}

	TreeNode(int x) { val = x; }

	public void setVal(int val) {
		this.val = val;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
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
