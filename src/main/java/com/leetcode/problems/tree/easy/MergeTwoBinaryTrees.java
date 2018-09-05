package com.leetcode.problems.tree.easy;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 */
public class MergeTwoBinaryTrees {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
			if (t1 == null && t2 == null) {
				return null;
			} else if (t1 != null && t2 != null) {
				TreeNode node = new TreeNode(t1.val + t2.val);
				node.left = mergeTrees(t1.left, t2.left);
				node.right = mergeTrees(t1.right, t2.right);
				return node;
			} else if (t1 != null) {
				TreeNode node = new TreeNode(t1.val);
				node.left = t1.left;
				node.right = t1.right;
				return node;
			} else {
				TreeNode node = new TreeNode(t2.val);
				node.left = t2.left;
				node.right = t2.right;
				return node;
			}
		}
	}

//	public class TreeNode {
//		int val;
//		TreeNode left;
//		TreeNode right;
//
//		TreeNode() {
//
//		}
//
//		TreeNode(int x) { val = x; }
//
//		public void setVal(int val) {
//			this.val = val;
//		}
//
//		public void setLeft(TreeNode left) {
//			this.left = left;
//		}
//
//		public void setRight(TreeNode right) {
//			this.right = right;
//		}
//
//		@Override
//		public boolean equals(Object o) {
//			if (this == o) return true;
//			if (o == null || getClass() != o.getClass()) return false;
//			TreeNode treeNode = (TreeNode) o;
//			return val == treeNode.val &&
//					Objects.equals(left, treeNode.left) &&
//					Objects.equals(right, treeNode.right);
//		}
//
//		@Override
//		public int hashCode() {
//
//			return Objects.hash(val, left, right);
//		}
//	}

}
