package com.leetcode.problems.tree.medium;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (preorder.length == 0) {
				return null;
			}
			if (preorder.length == 1) {
				return new TreeNode(preorder[0]);
			} else {
				TreeNode node = new TreeNode(preorder[0]);
				int split = 0;
				for (; split < preorder.length; split++) {
					if (inorder[split] == preorder[0]) {
						break;
					}
				}
				int[] leftPre = new int[split];
				int[] rightPre = new int[preorder.length - split - 1];

				int[] leftIn = new int[split];
				int[] rightIn = new int[preorder.length - split - 1];

				System.arraycopy(preorder, 1, leftPre, 0, leftPre.length);
				System.arraycopy(inorder, 0, leftIn, 0, leftIn.length);

				System.arraycopy(preorder, split + 1, rightPre, 0, rightPre.length);
				System.arraycopy(inorder, split + 1, rightIn, 0, rightIn.length);

				node.left = buildTree(leftPre, leftIn);
				node.right = buildTree(rightPre, rightIn);

				return node;
			}
		}
	}

}
