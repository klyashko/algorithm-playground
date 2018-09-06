package com.leetcode.problems.tree.hard;

import com.leetcode.problems.tree.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */
@SuppressWarnings("Duplicates")
public class SerializeAndDeserializeBinaryTree {

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
	public class Codec {

		private final String NULL = "-";
		private final String DELIMITER = ",";

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder builder = new StringBuilder();
			toStringBuilder(root, builder);
			return builder.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.isEmpty()) {
				return null;
			}
			return valueOf(data.split(DELIMITER), new int[]{0});
		}

		private TreeNode valueOf(String[] values, int[] idx) {
			int i = idx[0];
			idx[0]++;
			if (NULL.equals(values[i])) {
				return null;
			}
			TreeNode node = new TreeNode(Integer.valueOf(values[i]));
			node.left = valueOf(values, idx);
			node.right = valueOf(values, idx);
			return node;
		}

		private void toStringBuilder(TreeNode node, StringBuilder builder) {
			if (node == null) {
				builder.append(NULL).append(DELIMITER);
				return;
			}
			builder.append(String.valueOf(node.val)).append(DELIMITER);
			toStringBuilder(node.left, builder);
			toStringBuilder(node.right, builder);
		}
	}

}
